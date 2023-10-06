package org.windsurfers.dto;

import lombok.Builder;

import java.util.List;

@Builder

public record WeatherDataDto(
        List<WeatherDto> data,
        String city_name

        ) {

        }

