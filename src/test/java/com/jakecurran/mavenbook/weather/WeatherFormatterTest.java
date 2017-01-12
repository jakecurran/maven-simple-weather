package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import junit.framework.TestCase;

import com.jakecurran.mavenbook.weather.Location;
import com.jakecurran.mavenbook.weather.LocationParser;
import com.jakecurran.mavenbook.weather.Weather;
import com.jakecurran.mavenbook.weather.WeatherParser;
import com.jakecurran.mavenbook.weather.WeatherFormatter;

public class WeatherFormatterTest extends TestCase {
  public WeatherFormatterTest(String name) {
    super(name);
  }

  public void testFormat() throws Exception {
    InputStream nyGeocode = getClass().getClassLoader().getResourceAsStream("ny_geocode.json");
    Location ny = new LocationParser().parse(nyGeocode);


    InputStream nyData = getClass().getClassLoader().getResourceAsStream("ny_weather.json");
    Weather nyWeather = new WeatherParser().parse(nyData);

    String formattedWeather = new WeatherFormatter().format(ny, nyWeather);
    InputStream expected = getClass().getClassLoader().getResourceAsStream("ny_formatted_weather.txt");

    assertEquals(IOUtils.toString(expected).trim(), formattedWeather.trim());
  }
}
