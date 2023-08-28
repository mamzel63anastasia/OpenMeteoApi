package org.openmeteoapi;

import org.openmeteoapi.model.GeoObject;
import org.openmeteoapi.model.Weather;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
//        HttpClient client = new HttpClient("30f1d5e8-b51f-42a5-a9e9-a6c206cd5efc");
//        HttpClientResponse response = client.get("https://api.weather.yandex.ru/v2/forecast?lat=55.75396&lon=37.620393&extra=true");
//        System.out.println(response.getStatus());

        ApiWeather apiWeather = new ApiWeather("30f1d5e8-b51f-42a5-a9e9-a6c206cd5efc");
       // ApiGeo apiGeo = new ApiGeo("b387a262-6f1a-4160-9425-75398f8887ea");

        List<GeoObject> geoObjectList = apiWeather.searchGeoObject(new GeoObject("Россия", "55.75396", "37.620393"));
        Weather weather = apiWeather.currentWeather(geoObjectList.get(0));
        System.out.println(weather.getTemperature());


    }
}