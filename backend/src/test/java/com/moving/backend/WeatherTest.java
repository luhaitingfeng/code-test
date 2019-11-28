package com.moving.backend;

import com.moving.backend.controller.PetController;
import com.moving.backend.controller.WeatherController;
import com.moving.backend.pojo.ResponseOutput;
import com.moving.backend.pojo.pet.PetListGroupOutput;
import com.moving.backend.pojo.weather.WeatherInput;
import com.moving.backend.pojo.weather.WeatherOutput;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * <h3>com.moving.backend</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 18:18
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {BackendApplication.class})
public class WeatherTest {
    @Autowired
    private WeatherController weatherController;

    @Test
    public void testWeatherController(){
        ResponseOutput<List<String>> responseOutput = weatherController.cities();
        Assert.assertNotNull(responseOutput.getData());
    }

    @Test
    public void testWeatherCityController() throws IOException {

        WeatherInput weatherInput = new WeatherInput();
        weatherInput.setCity("Melbourne");
        ResponseOutput<WeatherOutput> responseOutput = weatherController.cityWeather(weatherInput);
        Assert.assertNotNull(responseOutput.getData());
    }
}
