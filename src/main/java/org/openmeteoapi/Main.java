package org.openmeteoapi;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ApiWeather apiWeather = new ApiWeather("30f1d5e8-b51f-42a5-a9e9-a6c206cd5efc");
        System.out.println(apiWeather.currentWeather(55.75396, 37.620393));
    }
}