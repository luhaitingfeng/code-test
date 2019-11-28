package com.moving.backend.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <h3>com.moving.backend.constant</h3>
 * <p></p>
 *
 * @author : Luhaitingfeng
 * @date : 2019-11-28 18:01
 **/
@Component
@ConfigurationProperties(prefix = "custom.backend")
public class BackendProperty {

    private RapidapiWeather rapidapiWeather;

    public static class RapidapiWeather{
        private List<String> cities;
        private String host;
        private String key;
        private String url;

        public List<String> getCities() {
            return cities;
        }

        public void setCities(List<String> cities) {
            this.cities = cities;
        }

        public String getHost() {
            return host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public RapidapiWeather getRapidapiWeather() {
        return rapidapiWeather;
    }

    public void setRapidapiWeather(RapidapiWeather rapidapiWeather) {
        this.rapidapiWeather = rapidapiWeather;
    }
}
