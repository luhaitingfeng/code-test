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
    WeatherOutput findCurrentCityWeather(WeatherInput weatherInput) throws IOException;
}
