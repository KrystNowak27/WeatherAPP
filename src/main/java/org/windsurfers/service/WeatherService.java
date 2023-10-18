package org.windsurfers.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windsurfers.dto.WeatherDataDto;

import org.windsurfers.utils.WeatherCalculator;
import org.windsurfers.webclient.WeatherClient;

import java.util.List;



@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherCalculator weatherCalculator;
    private final WeatherClient weatherClient;

    public WeatherDataDto getBestCityWeather(String datetime) {
        List<WeatherDataDto> allWeatherForCities = weatherClient.getWeatherForCities();

        return weatherCalculator.getBestCityWeather(allWeatherForCities, datetime);
    }
}







