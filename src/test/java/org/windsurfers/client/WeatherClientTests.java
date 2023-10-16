package org.windsurfers.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.enums.City;
import org.windsurfers.webclient.WeatherClient;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class WeatherClientTests {

    @InjectMocks
    private WeatherClient weatherClient;

    @Mock
    private RestTemplate restTemplate;

    public WeatherClientTests() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getWeatherForCities_shouldReturnWeatherDataForAllCities() {
        // Given
        when(restTemplate.getForObject(any(String.class), any(), any(Object[].class)))
                .thenReturn(new WeatherDataDto());

        // When
        List<WeatherDataDto> weatherDataList = weatherClient.getWeatherForCities();

        // Then
        assertEquals(City.values().length, weatherDataList.size());
    }





}
