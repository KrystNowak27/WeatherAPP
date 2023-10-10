//package org.windsurfers.service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.windsurfers.dto.WeatherDataDto;
//import org.windsurfers.dto.WeatherDto;
//
//import java.time.LocalDate;
//import java.util.Comparator;
//import java.util.Date;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Component
//public class WeatherFilter {
//
//    private WeatherService weatherService;
//
//    @Autowired
//    public WeatherFilter(WeatherService weatherService) {
//        this.weatherService = weatherService;
//    }
//
//    public WeatherDataDto getBestLocation() {
//        List<WeatherDataDto> weatherForCities = weatherService.getWeatherForCities();
//    }