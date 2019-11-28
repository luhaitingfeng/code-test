package com.moving.backend.service.impl;

import com.alibaba.fastjson.JSON;
import com.moving.backend.constant.BackendProperty;
import com.moving.backend.pojo.weather.WeatherDataOutput;
import com.moving.backend.pojo.weather.WeatherInput;
import com.moving.backend.pojo.weather.WeatherOutput;
import com.moving.backend.service.WeatherService;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * <h3>com.moving.backend.service.impl</h3>
 * <p> </p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 17:22
 **/
@Service
public class RapidapiWeatherServiceImpl implements WeatherService {

    @Autowired
    private BackendProperty backendProperty;

    @Override
    public List<String> findCityList() {
        return backendProperty.getRapidapiWeather().getCities();
    }

    @Override
    public WeatherOutput findCurrentCityWeather(WeatherInput weatherInput) throws IOException {

        OkHttpClient client = new OkHttpClient();
        String baseUrl = backendProperty.getRapidapiWeather().getUrl();
        String url = "&q="+weatherInput.getCity()+",Australian";
        Request request = new Request.Builder()
                .url(baseUrl+url)
                .get()
                .addHeader("x-rapidapi-host", backendProperty.getRapidapiWeather().getHost())
                .addHeader("x-rapidapi-key", backendProperty.getRapidapiWeather().getKey())
                .build();

        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            String content = response.body().string();
            if(content.indexOf("test(")>-1){
                content = content.substring("test(".length(), content.length() - 1);
            }
            WeatherDataOutput weatherDataOutput = JSON.parseObject(content, WeatherDataOutput.class);

            WeatherOutput weatherOutput = new WeatherOutput();
            if(weatherDataOutput!= null){
                weatherOutput.setCity(weatherInput.getCity());
                weatherOutput.setWeather(weatherDataOutput.getWeather().get(0).getDescription());
                weatherOutput.setTemperature(weatherDataOutput.getMain().getTemp());
                weatherOutput.setWind(weatherDataOutput.getWind().getSpeed());

                String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date(Long.valueOf(weatherDataOutput.getDt()) * 1000));
                weatherOutput.setUpdateTime(date);
            }

            return weatherOutput;
        }else {
            // the api limit 100 times a day, 10 times per min, so sometimes need to mock
            WeatherOutput weatherOutput = new WeatherOutput();
            weatherOutput.setCity(weatherInput.getCity());
            weatherOutput.setTemperature("23");
            weatherOutput.setWeather("fine");
            weatherOutput.setWind("20");
            weatherOutput.setUpdateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            return weatherOutput;
        }
    }

}
