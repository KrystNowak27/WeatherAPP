package org.windsurfers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windsurfers.dto.WeatherDataDto;

import org.windsurfers.utils.WeatherCalculator;
import org.windsurfers.webclient.WeatherClient;

import java.util.List;



@Service
public class WeatherService {

    private final WeatherCalculator weatherCalculator;
    private final WeatherClient weatherClient;

    @Autowired
    public WeatherService(WeatherCalculator weatherCalculator, WeatherClient weatherClient) {
        this.weatherCalculator = weatherCalculator;
        this.weatherClient = weatherClient;
    }

    public WeatherDataDto getBestCityWeather(String datetime) {
        List<WeatherDataDto> allWeatherForCities = weatherClient.getWeatherForCities();

        return weatherCalculator.getBestCityWeather(allWeatherForCities, datetime);
    }
}







