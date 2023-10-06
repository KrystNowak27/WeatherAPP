package org.windsurfers.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.webclient.weather.WeatherClient;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class WeatherService {
    private WeatherClient weatherClient;

    public List<WeatherDataDto> getWeatherForCities() {
        return weatherClient.getWeatherForCity();
    }
}