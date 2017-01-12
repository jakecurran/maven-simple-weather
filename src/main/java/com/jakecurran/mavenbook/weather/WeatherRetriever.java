package com.jakecurran.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class WeatherRetriever {
  private static final String darkSkyKey = "DARKSKY_API_KEY";

  private static Logger log = Logger.getLogger(WeatherRetriever.class);

  public InputStream retrieve(Location location) throws Exception {
    log.info("\tWeatherRetriever.retrieve()");

    String url = "https://api.darksky.net/forecast/" + darkSkyKey + "/" +
                 location.getLatitude() + "," + location.getLongitude()
                 + "?units=ca";

    URLConnection connection = new URL(url).openConnection();
    log.info("\t\tOpen connection at URL: " + url);

    log.info("\t\tRETURN: InputStream containing weather JSON from Dark Sky");
    return connection.getInputStream();
  }
}
