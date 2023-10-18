package org.windsurfers.webclient;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.enums.City;


import java.util.ArrayList;
import java.util.List;


@Component
public class WeatherClient {

    private static final String WEATHER_URL = "https://api.weatherbit.io/v2.0/forecast/daily?";
    private static final String API_KEY = "f709035defd94163a868b75ef560bbbd";
    private static final Integer DAYS = 16;
    private RestTemplate restTemplate = new RestTemplate();

    public List<WeatherDataDto> getWeatherForCities(){

        List<WeatherDataDto>weatherDataDtos = new ArrayList<>();

        for(City city : City.values()) {
            WeatherDataDto weatherData = callGetMethod("city={city}&days={days}&key={apiKey}",
                    WeatherDataDto.class,
                    city.getCity(), DAYS, API_KEY);
            weatherDataDtos.add(weatherData);
        }

return weatherDataDtos;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}