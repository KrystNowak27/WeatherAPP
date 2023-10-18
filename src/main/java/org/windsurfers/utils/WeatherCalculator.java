package org.windsurfers.utils;

import org.springframework.stereotype.Component;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.dto.WeatherDto;
import org.windsurfers.exceptions.InvalidDateException;
import org.windsurfers.exceptions.InvalidDateFormatException;
import org.windsurfers.exceptions.NoEnterDateException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Component
public class WeatherCalculator {

    private static final int MIN_TEMP = 5;
    private static final int MAX_TEMP = 35;
    private static final int MIN_WIND_SPEED = 5;
    private static final int MAX_WIND_SPEED = 18;
    private static final int ALLOWED_NUMBER_OF_DAYS = 15;


    public WeatherDataDto getBestCityWeather(List<WeatherDataDto> allWeatherForCities, String datetime) {

        return allWeatherForCities.stream()
                .map(weatherDataDto -> calculateCityValue(weatherDataDto, datetime))
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(WeatherDataDto::getCityValue))
                .orElse(null);
    }

    private WeatherDataDto calculateCityValue(WeatherDataDto weatherDataDto, String datetime) {

        if (datetime.isBlank()) {
            throw new NoEnterDateException("Datetime cannot be null. Please enter the date in the format: YYYY-MM-DD! ");
        } else if (!isValidDateFormat(datetime)) {
            throw new InvalidDateFormatException(datetime+" -Invalid date format. Please enter the date in the format: YYYY-MM-DD!");
        } else if (isDateNotAtForecast(datetime)) {
            throw new InvalidDateException("Date "+ datetime + " is invalid. Please enter today's or the next 15 days date.");
        }
            List<WeatherDto> filteredData = weatherDataDto.getData().stream()
                    .filter(data -> data.getDatetime().equals(datetime) &&
                            data.getTemp() > MIN_TEMP && data.getTemp() < MAX_TEMP &&
                            data.getWindSpeed() > MIN_WIND_SPEED && data.getWindSpeed() < MAX_WIND_SPEED)
                    .toList();

            if (filteredData.isEmpty()) {
                return null;
            }

            double cityValue = filteredData.stream()
                    .mapToDouble(data -> data.getTemp() * 3 + data.getWindSpeed())
                    .sum();

            return WeatherDataDto.builder()
                    .cityName(weatherDataDto.getCityName())
                    .data(filteredData)
                    .cityValue(cityValue)
                    .build();
        }

    private boolean isValidDateFormat(String datetime) {
        String regex = "\\d{4}-\\d{2}-\\d{2}";
        return datetime.matches(regex);
    }

    private boolean isDateNotAtForecast(String datetime) {
        LocalDate inputDate = LocalDate.parse(datetime);
        LocalDate today = LocalDate.now();
        LocalDate futureDate = today.plusDays(ALLOWED_NUMBER_OF_DAYS);
        return inputDate.isBefore(today) || inputDate.isAfter(futureDate);
    }
}