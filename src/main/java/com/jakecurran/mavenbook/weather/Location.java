package com.jakecurran.mavenbook.weather;

public class Location {
  private String latitude;
  private String longitude;

  private String address;

  public Location() {}

  public String getLatitude() { return latitude; }
  public void setLatitude(String latitude) { this.latitude = latitude; }

  public String getLongitude() { return longitude; }
  public void setLongitude(String longitude) { this.longitude = longitude; }

  public String getAddress() { return address; }
  public void setAddress(String address) { this.address = address; }
}
