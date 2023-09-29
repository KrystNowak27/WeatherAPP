package org.windsurfers;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {
    private static final String WEATHER_URL = "http://api.weatherbit.io/v2.0/forecast/daily";
    private static final String API_KEY = "f709035defd94163a868b75ef560bbbd";
    private RestTemplate restTemplate = new RestTemplate();


    private String getWeatherForCity(String city){
        return restTemplate.getForObject(WEATHER_URL + )
    }
}
