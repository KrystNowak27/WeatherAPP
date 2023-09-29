package org.windsurfers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windsurfers.service.WeatherForecast;
import org.windsurfers.service.WeatherbitService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherbitService weatherbitService;

    @Autowired
    public WeatherController(WeatherbitService weatherbitService) {
        this.weatherbitService = weatherbitService;
    }

    @GetMapping("/{date}")
    public WeatherForecast getWeather(@PathVariable String date) {
        return weatherbitService.getWeatherForecast(date);
    }
}