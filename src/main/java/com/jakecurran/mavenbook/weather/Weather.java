package com.jakecurran.mavenbook.weather;

public class Weather {
  private String condition;
  private String temperature;
  private String apparentTemperature;
  private String humidity;

  public Weather() {}

  public String getCondition() { return condition; }
  public void setCondition(String condition) { this.condition = condition; }

  public String getTemperature() { return temperature; }
  public void setTemperature(String temperature) { this.temperature = temperature; }

  public String getApparentTemperature() { return apparentTemperature; }
  public void setApparentTemperature(String apparentTemperature) { this.apparentTemperature = apparentTemperature; }

  public String getHumidity() { return humidity; }
  public void setHumidity(String humidity) { this.humidity = humidity; }
}
