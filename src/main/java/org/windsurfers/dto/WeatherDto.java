package org.windsurfers.dto;


import lombok.Builder;


@Builder
public record WeatherDto(
        String city,
        Double temp ,
        Double wind_spd,
        String datetime) {
}