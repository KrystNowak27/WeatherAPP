package org.windsurfers.utils;

import org.springframework.stereotype.Component;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.dto.WeatherDto;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class WeatherCalculator {

    public WeatherDataDto calculateCityValue(WeatherDataDto weatherDataDto, String datetime) {
        List<WeatherDto> filteredData = weatherDataDto.getData().stream()
                .filter(data -> data.getDatetime().equals(datetime) &&
                        data.getTemp() > 5 && data.getTemp() < 35 &&
                        data.getWind_spd() > 5 && data.getWind_spd() < 18)
                .collect(Collectors.toList());

        if (filteredData.isEmpty()) {
            return null;
        }

        double cityValue = filteredData.stream()
                .mapToDouble(data -> data.getTemp() * 3 + data.getWind_spd())
                .sum();

        return WeatherDataDto.builder()
                .city_name(weatherDataDto.getCity_name())
                .data(filteredData)
                .cityValue(cityValue)
                .build();
    }

    public WeatherDataDto getBestCityWeather(List<WeatherDataDto> allWeatherForCities, String datetime) {
        return allWeatherForCities.stream()
                .map(weatherDataDto -> calculateCityValue(weatherDataDto, datetime))
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(WeatherDataDto::getCityValue))
                .orElse(null);
    }

}