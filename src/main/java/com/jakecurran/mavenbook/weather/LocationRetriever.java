package com.jakecurran.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.apache.log4j.Logger;

public class LocationRetriever {
  private static Logger log = Logger.getLogger(WeatherRetriever.class);

  private static final String geocodeURL = "https://maps.googleapis.com/maps/api/geocode/json?";

  public InputStream retrieve(String address) throws Exception {
    log.info("\tLocationRetriever.retrieve()");

    String url = geocodeURL + "address=" + address;

    URLConnection connection = new URL(url).openConnection();
    log.info("\t\tOpen connection at URL: " + url);

    log.info("\t\tRETURN: InputStream containing geocode JSON grom Google");
    return connection.getInputStream();
  }
}
