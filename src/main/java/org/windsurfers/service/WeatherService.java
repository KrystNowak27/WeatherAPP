package org.windsurfers.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.dto.WeatherDto;
import org.windsurfers.webclient.weather.WeatherClient;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class WeatherService {


    private WeatherClient weatherClient;
    @Autowired
    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }



    public List<WeatherDataDto> getWeatherForCities() {
        List<WeatherDataDto> weatherForCities = weatherClient.getWeatherForCities();
        return weatherForCities;
    }



}