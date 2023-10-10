package org.windsurfers.dto;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto{
        Double temp;
        Double wind_spd;
        String datetime;


}