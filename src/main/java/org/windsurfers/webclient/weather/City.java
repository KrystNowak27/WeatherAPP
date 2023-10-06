package org.windsurfers.webclient.weather;

public enum City {
    JASTARNIA("Jastarnia"),
    BRIDGETOWN("Bridgetown"),
    FORTALEZA("Fortaleza"),
    PISSOURI("Pissouri"),
    LE_MORNE("Le Morne");



    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCity() {
        return cityName;
    }
}
