package com.jakecurran.mavenbook.weather;

import java.util.Scanner;
import java.io.InputStream;
import com.google.gson.*;

public class LocationParser {
  public Location parse(InputStream locationData) throws Exception {
    // Convert location data from InputStream to String
    Scanner scanner = new Scanner(locationData).useDelimiter("\\A");
    String locationJSON = scanner.hasNext() ? scanner.next() : "";

    // Parse JSON string using Gson
    JsonParser parser = new JsonParser();
    JsonObject geocode = parser.parse(locationJSON).getAsJsonObject();

    // Create Location object
    Location location = new Location();
    JsonArray results = geocode.getAsJsonArray("results");

    // Set Location's address
    JsonObject root = results.get(0).getAsJsonObject();
    location.setAddress(root.get("formatted_address").getAsString());

    // Set Location's coordinates
    JsonObject coordinates = root.getAsJsonObject("geometry").getAsJsonObject("location");
    location.setLatitude(coordinates.get("lat").getAsString());
    location.setLongitude(coordinates.get("lng").getAsString());

    return location;
  }
}
