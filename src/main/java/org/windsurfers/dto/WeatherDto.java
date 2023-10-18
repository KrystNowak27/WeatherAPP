package org.windsurfers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDto{
        Double temp;
        @JsonProperty("wind_spd")
        Double windSpeed;
        String datetime;
}