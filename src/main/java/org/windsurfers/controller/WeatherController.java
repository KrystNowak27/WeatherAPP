package org.windsurfers.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.windsurfers.dto.WeatherDataDto;

import org.windsurfers.service.WeatherService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private  final WeatherService weatherService;



    @GetMapping("/best-city")
    public ResponseEntity<WeatherDataDto> getBestCityWeather(@RequestParam  String datetime) {
        WeatherDataDto bestCityWeather = weatherService.getBestCityWeather(datetime);
        return new ResponseEntity<>(bestCityWeather, HttpStatus.OK);
    }
}

