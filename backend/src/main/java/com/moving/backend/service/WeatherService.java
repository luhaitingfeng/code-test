package com.moving.backend.service;

import com.moving.backend.pojo.weather.WeatherInput;
import com.moving.backend.pojo.weather.WeatherOutput;

import java.io.IOException;
import java.util.List;

/**
 * <h3>com.moving.backend.service</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 17:19
 **/
public interface WeatherService {
    List<String> findCityList();

    /**
     * <a href="https://rapidapi.com/community/api/open-weather-map/endpoints">api website</a>
     * <p>Notice that the api limits 100 times a day, 10 times per min</p>
     * @param weatherInput
     * @return
     * @throws IOException
     */
    WeatherOutput findCurrentCityWeather(WeatherInput weatherInput) throws IOException;
}
