package org.windsurfers.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataDto{
        List<WeatherDto> data;
        @JsonProperty("city_name")
        String cityName;
        @JsonProperty("city_value")
        double cityValue;
}