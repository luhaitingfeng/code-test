package com.moving.backend.controller;

import com.moving.backend.pojo.ResponseOutput;
import com.moving.backend.pojo.weather.WeatherInput;
import com.moving.backend.pojo.weather.WeatherOutput;
import com.moving.backend.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * <h3>com.moving.backend.controller</h3>
 * <p>WeatherController</p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 16:48
 **/
@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/api/cities.backend")
    public ResponseOutput<List<String>> cities()  {
        List<String> cityList = weatherService.findCityList();
        return ResponseOutput.ok(cityList);
    }

    @PostMapping("/api/cityWeather.backend")
    public ResponseOutput<WeatherOutput> cityWeather(@RequestBody WeatherInput weatherInput) throws IOException {
        WeatherOutput currentCityWeather = weatherService.findCurrentCityWeather(weatherInput);
        return ResponseOutput.ok(currentCityWeather);
    }
}
