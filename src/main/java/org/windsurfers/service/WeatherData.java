package org.windsurfers.service;

public class WeatherData {
    private String locationName;
    private double temperature;
    private double windSpeed;




    public WeatherData(String locationName, double temperature, double windSpeed) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
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
}
