package org.windsurfers.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto{
        String city;
        Double temp;
        Double wind_spd;
        String datetime;


}