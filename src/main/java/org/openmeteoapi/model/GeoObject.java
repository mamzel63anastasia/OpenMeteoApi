package org.openmeteoapi.model;

public class GeoObject {

   private String name;
    private String lat;
   private String lon;

    public GeoObject(String name) {
        this.name = name;
    }

    public GeoObject(String name, String lat, String lon) {
        this.name = name;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "lat=" + lat + "&lon=" + lon;
    }
}
