package org.openmeteoapi;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.openmeteoapi.model.GeoObject;
import org.openmeteoapi.model.HttpClientResponse;
import org.openmeteoapi.model.Weather;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiWeather {
    private final String apiKey;

    public ApiWeather(String apiKey) {
        this.apiKey = apiKey;
    }

    public List<GeoObject> searchGeoObject(GeoObject geoObject) {
        List<GeoObject> list = new ArrayList<>();
        list.add(new GeoObject(geoObject.getName(), geoObject.getLat(), geoObject.getLon()));
        return list;
    }



    public Weather currentWeather(GeoObject geoObject) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Yandex-API-Key", apiKey);
        HttpClient httpClient = new HttpClient();
        HttpClientResponse response =
                httpClient.get("https://api.weather.yandex.ru/v2/forecast?" + geoObject + "&extra=true", headers);
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
