package org.windsurfers.service;


import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherbitService {

    private final WebClient webClient;
    private final String apiKey = "f709035defd94163a868b75ef560bbbd";

    public WeatherbitService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://api.weatherbit.io/v2.0").build();
    }

    public WeatherForecast getWeatherForecast(String date) {
        return webClient.get()
                .uri("/forecast/daily?city=Jastarnia,PL&key=" + apiKey)
                .retrieve()
                .bodyToMono(WeatherForecast.class)
                .block();
    }
}
