package com.jakecurran.mavenbook.weather;

import java.util.Scanner;
import org.apache.log4j.Logger;
import java.io.InputStream;
import com.google.gson.*;

public class LocationParser {
  private static Logger log = Logger.getLogger(WeatherRetriever.class);

  public Location parse(InputStream locationData) throws Exception {
    log.info("\tLocationParser.parse()");

    log.info("\t\tConvert location data from InputStream to String");
    Scanner scanner = new Scanner(locationData).useDelimiter("\\A");
    String locationJSON = scanner.hasNext() ? scanner.next() : "";

    log.info("\t\tCreatie JSON parser and parse JSON text");
    JsonParser parser = new JsonParser();
    JsonObject geocode = parser.parse(locationJSON).getAsJsonObject();

    log.info("\t\tCreate Location object and extract values from parsed JSON to set properties");
    Location location = new Location();
    JsonArray results = geocode.getAsJsonArray("results");

    JsonObject root = results.get(0).getAsJsonObject();
    location.setAddress(root.get("formatted_address").getAsString());
    log.info("\t\t\tAddress: " + location.getAddress());

    JsonObject coordinates = root.getAsJsonObject("geometry").getAsJsonObject("location");
    location.setLatitude(coordinates.get("lat").getAsString());
    log.info("\t\t\tLatitude: " + location.getLatitude());
    location.setLongitude(coordinates.get("lng").getAsString());
    log.info("\t\t\tLongitude: " + location.getLongitude());

    log.info("\t\tRETURN: Location object");
    return location;
  }
}
