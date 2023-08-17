package org.openmeteoapi;

import org.openmeteoapi.model.City;
import org.openmeteoapi.model.HttpClientResponse;
import org.openmeteoapi.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class ApiWeather {
    private final String apiKey;

    public ApiWeather(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<City> searchCity (String name, int len){
        List<City> list = new ArrayList<>();
        list.add(new City("Москва", 55.75396, 37.620393));
        return list;
    }

    public List<City> searchCity(String name) {
        return searchCity(name, 10);
    }

    public Weather currentWeather(City city) {
        HttpClient httpClient =  new HttpClient(apiKey);
        HttpClientResponse response = httpClient.get("https://api.weather.yandex.ru/v2/forecast?" + city + "&extra=true");

        System.out.println(response.getResponse());


        Weather weather = new Weather();
        return new  Weather(weather.getTemperature(), weather.getCity());
    }
}
