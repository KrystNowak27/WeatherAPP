package org.windsurfers.controller;//package org.windsurfers.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.windsurfers.service.WeatherService;
//
//@RestController
//@RequiredArgsConstructor
//public class WeatherController {
//    private final WeatherService service;
//
//
//    @GetMapping(path = "/api/weather")
//    public ResponseEntity<String> getWeather() {
//        final String response = service.getWeather();
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//}
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/cities")
    public ResponseEntity<List<WeatherDataDto>> getWeatherForCities() {
        List<WeatherDataDto> weatherData = weatherService.getWeatherForCities();
        return new ResponseEntity<>(weatherData, HttpStatus.OK);
    }
}
