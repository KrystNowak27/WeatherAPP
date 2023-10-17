package org.windsurfers.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.windsurfers.dto.WeatherDataDto;



import org.windsurfers.service.WeatherService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;


    //masz lombok to uzyj @RequireArgsConstructo i zrob pole weatherService final
    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;

    }

    @GetMapping("/best-city")
    //jesli datetime jest na false to co sie zrobi dla nulla?
    public ResponseEntity<WeatherDataDto> getBestCityWeather(@RequestParam(required = false) String datetime) {
        WeatherDataDto bestCityWeather = weatherService.getBestCityWeather(datetime);
        return new ResponseEntity<>(bestCityWeather, HttpStatus.OK);
    }
}

