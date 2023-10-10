package org.windsurfers.service;

import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.dto.WeatherDto;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherCalculator {
    public WeatherCalculator() {
    }

    WeatherDataDto calculateCityValue(WeatherDataDto weatherDataDto, String datetime) {
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
}