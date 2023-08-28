package org.openmeteoapi;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.openmeteoapi.model.HttpClientResponse;

import java.util.HashMap;
import java.util.Map;

public class ApiWeather {
    private final String apiKey;

    public ApiWeather(String apiKey) {
        this.apiKey = apiKey;
    }

    public int currentWeather(double lat, double lon) {
        Map<String, String> headers = new HashMap<>();
        headers.put("X-Yandex-API-Key", apiKey);
        HttpClient httpClient = new HttpClient();
        HttpClientResponse response =
                httpClient.get("https://api.weather.yandex.ru/v2/forecast?" + "lat=" + lat + "&lon=" + lon + "&extra=true", headers);
        try {
            String json = response.getResponse();
            JSONObject jsonObject = (JSONObject) JSONValue.parseWithException(json);
            JSONObject fact = (JSONObject) jsonObject.get("fact");
            return Integer.parseInt(fact.get("temp").toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
