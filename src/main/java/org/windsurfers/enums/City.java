package org.windsurfers.enums;

public enum City {
    JASTARNIA("Jastarnia"),
    BRIDGETOWN("Bridgetown"),
    FORTALEZA("Fortaleza"),
    PISSOURI("Pissouri"),
    LE_MORNE("Le Morne");
// po co tyle linijk przerwy? zadbaj o styl kodu


    private final String cityName;

    City(String cityName) {
        this.cityName = cityName;
    }

    public String getCity() {
        return cityName;
    }
}
