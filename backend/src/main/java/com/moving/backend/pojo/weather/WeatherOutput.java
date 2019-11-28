package com.moving.backend.pojo.weather;

/**
 * <h3>com.moving.backend.pojo.weather</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 17:18
 **/
public class WeatherOutput {
    private String city;
    private String updateTime;
    private String weather;
    private String temperature;
    private String wind;


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }
}
