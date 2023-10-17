package org.windsurfers.dto;

import lombok.*;

import java.util.List;
@Builder
//to samo co w WeatherDataDto
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto{
        Double temp;
        //w kodzie uzywamy camelCase dla zmiennych
        Double wind_spd;
        String datetime;


}