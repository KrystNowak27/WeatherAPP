package org.windsurfers.webclient;

import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.windsurfers.dto.WeatherDataDto;
import org.windsurfers.enums.City;


import java.util.ArrayList;
import java.util.List;


@Component
// zapraszam do poczytania czym jest funkcja hashujaca i po co jest ta adnotacja, takich bledow nie mozna popelniac w pracy bo uznaja ze nie umiesz programowac
@EqualsAndHashCode
public class WeatherClient {

    //wszystko do application.yml/properties i @Value zeby wstrzykiwac z tego pliku;
    private static final String WEATHER_URL = "https://api.weatherbit.io/v2.0/forecast/daily?";
    private static final String API_KEY = "f709035defd94163a868b75ef560bbbd";
    private static final Integer DAYS = 16;
    //po to w AppConfig dales     @Bean
    //    public RestTemplate restTemplate() {
    //        return new RestTemplate();
    //    }
    // zeby teraz nie robic samemu new RestTemplate()
    //daj @RequireArgsConstrctor i oznacz RestTemplate jako final;
    private RestTemplate restTemplate = new RestTemplate();

    public List<WeatherDataDto> getWeatherForCities(){

        List<WeatherDataDto>weatherDataDtos = new ArrayList<>();

        for(City city : City.values()) {
            WeatherDataDto weatherData = callGetMethod("city={city}&days={days}&key={apiKey}",
                    WeatherDataDto.class,
                    city.getCity(), DAYS, API_KEY);
            weatherDataDtos.add(weatherData);
        }
//linijka kodu pod spodem poszla na spacer, zadbaj o formatowanie (ctrl + alt + L)
return weatherDataDtos;
    }

    private <T> T callGetMethod(String url, Class<T> responseType, Object... objects) {
        return restTemplate.getForObject(WEATHER_URL + url,
                responseType, objects);
    }
}