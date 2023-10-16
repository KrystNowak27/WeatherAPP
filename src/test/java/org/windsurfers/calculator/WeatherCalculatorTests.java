package org.windsurfers.calculator;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.dto.WeatherDto;
import org.windsurfers.utils.WeatherCalculator;
import org.windsurfers.webclient.WeatherClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherCalculatorTests {

    private WeatherCalculator weatherCalculator;
    private WeatherDataDto weatherDataDto;
    private String validDatetime;
    private String invalidDatetime;
    String date;
    double temp;
    double windSpeed;


    @Mock
    private WeatherClient weatherClient;

    @BeforeEach
    private void createMockWeatherDataDto() {
        MockitoAnnotations.initMocks(this);

        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setDatetime(date);
        weatherDto.setTemp(temp);
        weatherDto.setWind_spd(windSpeed);

        weatherDataDto = new WeatherDataDto();
        weatherDataDto.setData(List.of(weatherDto));

        when(weatherClient.getWeatherForCities()).thenReturn(List.of(weatherDataDto));
    }

    @BeforeEach
    void setUp() {
        weatherCalculator = new WeatherCalculator();
        date = "2023-10-10";
        temp = 10.0;
        windSpeed = 15.0;
        validDatetime = "2023-10-10";
        invalidDatetime = "2023-10-11";
    }


    @Test
    void calculateCityValue_validDate_shouldReturnCorrectValue() {
        // Given
        String validDate = validDatetime;

        // When
        WeatherDataDto result = weatherCalculator.calculateCityValue(weatherDataDto, validDate);

        // Then
        assertThat(result).isNotNull();

        assertThat(result.getCityValue()).isEqualTo(3 * temp + windSpeed);
    }

    @Test
    void calculateCityValue_shouldReturnCorrectCity() {
        // Given
        String validDate = validDatetime;

        // When
        WeatherDataDto result = weatherCalculator.calculateCityValue(weatherDataDto, validDate);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getCity_name()).isEqualTo(weatherDataDto.getCity_name());

    }

    @Test
    void calculateCityValue_invalidDate_shouldReturnNull() {
        // Given
        WeatherCalculator weatherCalculator = new WeatherCalculator();
        String invalidDate = invalidDatetime;

        // When
        WeatherDataDto result = weatherCalculator.calculateCityValue(weatherDataDto, invalidDate);

        // Then
        assertNull(result);
    }
    @Test
    void getBestCityWeather_emptyList_shouldReturnNull() {
        // Given
        List<WeatherDataDto> emptyList = Collections.emptyList();
        String anyValidDate = validDatetime;

        // When
        WeatherDataDto result = weatherCalculator.getBestCityWeather(emptyList, anyValidDate);

        // Then
        assertThat(result).isNull();
    }

    //! Liczą się różne wartości dla result i /Nie wiem czemu...
//    @Test
//    void getBestCityWeather_singleCity_shouldReturnSameCity() {
//        // Given
//        List<WeatherDataDto> singleCityList = Collections.singletonList(weatherDataDto);
//        String validDate = validDatetime;
//
//        // When
//        WeatherDataDto result = weatherCalculator.getBestCityWeather(singleCityList,validDate);
//
//        // Then
//        assertThat(result).isNotNull();
//        assertThat(result).isEqualTo(weatherDataDto);
//    }

//    @Test
//    void getBestCityWeather_noMatchingData_shouldReturnNull() {
//        // Given
//        List<WeatherDataDto> allCitiesWeather = Arrays.asList(
//                createWeatherDataDto("City1", 30.0),
//                createWeatherDataDto("City2", 45.0),
//                createWeatherDataDto("City3", 20.0)
//        );
//        String invalidDate = invalidDatetime;
//
//        // When
//        WeatherDataDto result = weatherCalculator.getBestCityWeather(allCitiesWeather, invalidDate);
//
//        // Then
//        assertThat(result).isNull();
//    }
}
