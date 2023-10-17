package org.windsurfers.utils;

import org.springframework.stereotype.Component;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.dto.WeatherDto;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class WeatherCalculator {

    //ta metoda jest uzywana tylko w weatherCalculator, zrob ja private i daj na samym dole klasy
    public WeatherDataDto calculateCityValue(WeatherDataDto weatherDataDto, String datetime) {
        List<WeatherDto> filteredData = weatherDataDto.getData().stream()
            //slabo logicznie, jesli datetime bedzie null to nie zwrocisz nic, a wypadaloby zwrocic 404 bad request
            // zrob customowy exception i GlobalHandlera ktory go zlapie i zwroci 404 z messagem
                .filter(data -> data.getDatetime().equals(datetime) &&
                    //czym jest 5 , 35, 18, 3? wchodze pierwszy raz w aplikacje i kompletnie nie wiem co to oznacza
                    // zrob stale private static final Integer MIN_TEMP = 5; itp.
                        data.getTemp() > 5 && data.getTemp() < 35 &&
                        data.getWind_spd() > 5 && data.getWind_spd() < 18)
            //uzywasz javy 17, wyszlo cos takiego jak .toList() zamiast .collect(Collectors.toList())
                .collect(Collectors.toList());

        if (filteredData.isEmpty()) {
            return null;
        }

        double cityValue = filteredData.stream()
                .mapToDouble(data -> data.getTemp() * 3 + data.getWind_spd())
                .sum();

        return WeatherDataDto.builder()
                .city_name(weatherDataDto.getCity_name())
                .data(filteredData)
                .cityValue(cityValue)
                .build();
    }

    public WeatherDataDto getBestCityWeather(List<WeatherDataDto> allWeatherForCities, String datetime) {
        return allWeatherForCities.stream()
                .map(weatherDataDto -> calculateCityValue(weatherDataDto, datetime))
                .filter(Objects::nonNull)
                .max(Comparator.comparingDouble(WeatherDataDto::getCityValue))
                .orElse(null);
    }

}