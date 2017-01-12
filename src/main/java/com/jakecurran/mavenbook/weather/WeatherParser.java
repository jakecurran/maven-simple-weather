package com.jakecurran.mavenbook.weather;

import java.util.Scanner;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.google.gson.*;

public class WeatherParser {
  private static Logger log = Logger.getLogger(WeatherParser.class);

  public Weather parse(InputStream weatherData) throws Exception {
    log.info("\tWeatherParser.parse()");

    log.info("\t\tCreate Weather object");
    Weather weather = new Weather();

    log.info("\t\tConvert weather data InputStream to String");
    Scanner s = new Scanner(weatherData).useDelimiter("\\A");
    String g = s.hasNext() ? s.next() : "";

    log.info("\t\tCreate JSON parser and parse weather JSON String");
    JsonParser p = new JsonParser();
    JsonObject darksky = p.parse(g).getAsJsonObject();

    log.info("\t\tExtract values from Json and set to Weather object properties");
    JsonObject currentWeather = darksky.getAsJsonObject("currently");

    weather.setCondition(currentWeather.get("summary").getAsString());
    log.info("\t\t\tCondition: " + weather.getCondition());

    weather.setTemperature(currentWeather.get("temperature").getAsString());
    log.info("\t\t\tTemperature: " + weather.getTemperature());

    weather.setApparentTemperature(currentWeather.get("apparentTemperature").getAsString());
    log.info("\t\t\tApparent Temperature: " + weather.getApparentTemperature());

    int humidity = (int) (currentWeather.get("humidity").getAsDouble() * 100);
    weather.setHumidity(Integer.toString(humidity));
    log.info("\t\t\tHumidity: " + weather.getHumidity());

    log.info("RETURN: Weather object");
    return weather;
  }
}
