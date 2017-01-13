package com.jakecurran.mavenbook.weather;

import java.util.Scanner;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.*;

public class WeatherParser {
  public Weather parse(InputStream weatherData) throws Exception {
    Weather weather = new Weather();

    // Convert weather data InputStream to String
    Scanner s = new Scanner(weatherData).useDelimiter("\\A");
    String g = s.hasNext() ? s.next() : "";

    // Parse JSON string using Gson
    JsonParser p = new JsonParser();
    JsonObject darksky = p.parse(g).getAsJsonObject();

    // Set Weather values from JSON properties
    JsonObject currentWeather = darksky.getAsJsonObject("currently");

    weather.setCondition(currentWeather.get("summary").getAsString());
    weather.setTemperature(currentWeather.get("temperature").getAsString());
    weather.setApparentTemperature(currentWeather.get("apparentTemperature").getAsString());

    // Humidity is converted from a number in range [0, 1] to a percent [0, 100]
    int humidity = (int) (currentWeather.get("humidity").getAsDouble() * 100);
    weather.setHumidity(Integer.toString(humidity));

    return weather;
  }
}
