package org.sonatype.mavenbook.weather;

import java.io.InputStream;
import junit.framework.TestCase;

import com.jakecurran.mavenbook.weather.Location;
import com.jakecurran.mavenbook.weather.LocationParser;

public class LocationParserTest extends TestCase {
  public LocationParserTest(String name) {
    super(name);
  }

  public void testParser() throws Exception {
    InputStream nyGeocode = getClass().getClassLoader().getResourceAsStream("ny_geocode.json");

    Location ny = new LocationParser().parse(nyGeocode);

    assertEquals("Empire State Building, 350 5th Ave, New York, NY 10118, USA", ny.getAddress());
    assertEquals("40.7484404", ny.getLatitude());
    assertEquals("-73.9856554", ny.getLongitude());
  }
}
