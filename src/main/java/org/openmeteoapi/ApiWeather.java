package org.openmeteoapi;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.openmeteoapi.model.GeoObject;
import org.openmeteoapi.model.HttpClientResponse;
import org.openmeteoapi.model.Weather;

import java.util.ArrayList;
import java.util.List;

public class ApiWeather {
    private final String apiKey;

    public ApiWeather(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<GeoObject> searchGeoObject(String name, int len) {
        List<GeoObject> list = new ArrayList<>();
        list.add(new GeoObject("Москва", 55.75396, 37.620393));
        return list;
    }

    public List<GeoObject> searchGeoObject(String name) {
        return searchGeoObject(name, 10);
    }

    public Weather currentWeather(GeoObject geoObject) {
        HttpClient httpClient = new HttpClient(apiKey);
        HttpClientResponse response = httpClient.get("https://api.weather.yandex.ru/v2/forecast?" + geoObject + "&extra=true");
        try {
            String json = response.getResponse();
            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(json);
            JSONObject fact = (JSONObject) jsonObject.get("fact");

            return new Weather(Integer.parseInt(fact.get("temp").toString()), geoObject);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
