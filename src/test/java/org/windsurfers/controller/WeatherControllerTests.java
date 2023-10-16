package org.windsurfers.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.windsurfers.controller.WeatherController;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.service.WeatherService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;




@ExtendWith(MockitoExtension.class)
public class WeatherControllerTests{

    @Mock
    private WeatherService weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void testGetBestCityWeather_ValidDatetime() {
        // given
        String datetime = "2023-10-10";
        WeatherDataDto expectedWeatherDataDto = WeatherDataDto.builder()
                .city_name("TestCity")
                .build();

        // when
        when(weatherService.getBestCityWeather(datetime)).thenReturn(expectedWeatherDataDto);

        ResponseEntity<WeatherDataDto> responseEntity = weatherController.getBestCityWeather(datetime);

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedWeatherDataDto, responseEntity.getBody());
    }

    @Test
    void GetBestCityWeather_WithoutDatetimeParam_() {
        // Given
        WeatherController weatherController = new WeatherController(weatherService);

        WeatherDataDto expectedWeather = new WeatherDataDto();

        when(weatherService.getBestCityWeather(null)).thenReturn(expectedWeather);

        // When
        ResponseEntity<WeatherDataDto> response = weatherController.getBestCityWeather(null);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedWeather, response.getBody());
    }

    @Test
    void testGetBestCityWeatherWithNullServiceResult() {
        // Given

        WeatherController weatherController = new WeatherController(weatherService);

        String datetime = "2023-10-01";

        when(weatherService.getBestCityWeather(datetime)).thenReturn(null);

        // When
        ResponseEntity<WeatherDataDto> response = weatherController.getBestCityWeather(datetime);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNull(response.getBody());
    }
}
