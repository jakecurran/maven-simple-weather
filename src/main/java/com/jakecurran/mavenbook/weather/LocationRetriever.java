package com.jakecurran.mavenbook.weather;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class LocationRetriever {
  private static final String geocodeURL = "https://maps.googleapis.com/maps/api/geocode/json?";

  public InputStream retrieve(String address) throws Exception {
    String url = geocodeURL + "address=" + URLEncoder.encode(address, "UTF-8");
    URLConnection connection = new URL(url).openConnection();

    return connection.getInputStream();
  }
}
