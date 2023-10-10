package org.windsurfers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windsurfers.dto.WeatherDataDto;

import org.windsurfers.webclient.weather.WeatherClient;


import java.util.Comparator;
import java.util.List;
import java.util.Objects;


@Service

public class WeatherService {


    private final WeatherCalculator wheatherCalculator = new WeatherCalculator();
    private WeatherClient weatherClient;

    @Autowired

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }




    public WeatherDataDto getBestCityWeather(String datetime) {
        List<WeatherDataDto> allWeatherForCities = weatherClient.getWeatherForCities();


        return allWeatherForCities.stream()
                .map(weatherDataDto -> wheatherCalculator.calculateCityValue(weatherDataDto, datetime))
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(WeatherDataDto::getCityValue))
                .orElse(null);
    }

    private WeatherDataDto calculateCityValue(WeatherDataDto weatherDataDto, String datetime) {

        return wheatherCalculator.calculateCityValue(weatherDataDto, datetime);
    }
}







