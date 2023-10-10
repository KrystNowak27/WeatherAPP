package org.windsurfers.dto;

import lombok.*;


import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataDto{
        List<WeatherDto> data;
        String city_name;
        double cityValue;
}