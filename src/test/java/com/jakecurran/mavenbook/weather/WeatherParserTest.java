package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import junit.framework.TestCase;

import com.jakecurran.mavenbook.weather.Weather;
import com.jakecurran.mavenbook.weather.WeatherParser;

public class WeatherParserTest extends TestCase {
  public WeatherParserTest(String name) {
    super(name);
  }

  public void testParser() throws Exception {
    InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny_weather.json");

    Weather nyWeather = new WeatherParser().parse(nyData);

    assertEquals("Mostly Cloudy", nyWeather.getCondition());
    assertEquals("11.87", nyWeather.getTemperature());
    assertEquals("9.42", nyWeather.getApparentTemperature());
    assertEquals("88", nyWeather.getHumidity());
  }
}
