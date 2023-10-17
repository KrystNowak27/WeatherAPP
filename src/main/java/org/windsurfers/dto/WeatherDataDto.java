package org.windsurfers.dto;

import lombok.*;


import java.util.List;

@Builder
//poczytaj o adnotacji @Data i @Value ktora ma wiekszosc tych adnotacji w sobie
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherDataDto{
        List<WeatherDto> data;

        //od kiedy w jednym robisz camelCase a w drugim _
        String city_name;
        double cityValue;
}