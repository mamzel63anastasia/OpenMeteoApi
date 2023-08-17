package org.openmeteoapi.model;

public class Weather {
    private String temp;
    private City city;

    public Weather(String temp, City city) {
        this.temp = temp;
        this.city = city;
    }

    public Weather() {
    }

    public String getTemperature() {
        return temp;
    }

    public void setTemperature(String temp) {
        this.temp = temp;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
