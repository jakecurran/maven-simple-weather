package com.jakecurran.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class WeatherRetriever {
  private static final String darkSkyKey = System.getenv("DARK_SKY_API_KEY");

  public InputStream retrieve(Location location) throws Exception {
    String url = "https://api.darksky.net/forecast/" + darkSkyKey + "/" +
                 location.getLatitude() + "," + location.getLongitude()
                 + "?units=ca";
    URLConnection connection = new URL(url).openConnection();

    return connection.getInputStream();
  }
}
