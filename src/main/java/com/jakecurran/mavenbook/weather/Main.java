package com.jakecurran.mavenbook.weather;

import java.io.InputStream;

public class Main {
  public static void main(String[] args) throws Exception {
    // Read address from the command line, use default if none is provided
    String address = "10118";
    try {
      address = args[0];
    } catch (Exception e) {}

    // Start the program
    new Main(address).start();
  }

  private String address;
  public Main(String address) { this.address = address; }

  public void start() throws Exception {
    // Retrieve location data corresponding to address
    InputStream locationData = new LocationRetriever().retrieve(address);

    // Parse location data
    Location location = new LocationParser().parse(locationData);

    // Retrieve weater data corresponding to location
    InputStream weatherData = new WeatherRetriever().retrieve(location);

    // Parse weather data
    Weather weather = new WeatherParser().parse(weatherData);

    // Format and print weather forcast
    System.out.print(new WeatherFormatter().format(location, weather));
  }
}
