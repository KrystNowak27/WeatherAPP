package org.windsurfers.service;


public class Location {
private String name;
private long temperature;
private long windSpeed;

    public Location(String name, long temperature, long windSpeed) {
        this.name = name;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTemperature() {
        return temperature;
    }

    public void setTemperature(long temperature) {
        this.temperature = temperature;
    }

    public long getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(long windSpeed) {
        this.windSpeed = windSpeed;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
