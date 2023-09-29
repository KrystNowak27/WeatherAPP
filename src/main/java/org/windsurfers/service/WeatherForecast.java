package org.windsurfers.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherForecast {


@JsonProperty("datetime")
private String datetime;

    @JsonProperty("temp")
    private double temperature;

    @JsonProperty("wind_spd")
    private double windSpeed;


    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    // Dodaj gettery i settery dla innych pól

    @Override
    public String toString() {
        return "WeatherForecast{" +
                "datetime='" + datetime + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                // Dodaj inne pola do reprezentacji tekstowej
                '}';
    }
}
