package org.openmeteoapi.model;

public class Weather {
    private int temp;
    private GeoObject geoObject;

    public Weather(int temp, GeoObject geoObject) {
        this.temp = temp;
        this.geoObject = geoObject;
    }

    public Weather() {
    }

    public int getTemperature() {
        return temp;
    }

    public void setTemperature(int temp) {
        this.temp = temp;
    }

    public GeoObject getCity() {
        return geoObject;
    }

    public void setCity(GeoObject geoObject) {
        this.geoObject = geoObject;
    }
}
