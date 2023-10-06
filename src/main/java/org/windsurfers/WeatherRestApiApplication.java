package org.windsurfers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan (basePackages = "org.windsurfers")
public class WeatherRestApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeatherRestApiApplication.class, args);

         }
}