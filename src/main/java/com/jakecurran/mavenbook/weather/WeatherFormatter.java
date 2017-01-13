package com.jakecurran.mavenbook.weather;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;

public class WeatherFormatter {
  public String format(Location location, Weather weather) throws Exception {
    // Read output format from 'output.vm' resource
    Reader reader = new InputStreamReader(
      getClass().getClassLoader().getResourceAsStream("output.vm")
    );

    // Create formatted output using Velocity
    VelocityContext context = new VelocityContext();
    context.put("location", location);
    context.put("weather", weather);

    StringWriter writer = new StringWriter();
    Velocity.evaluate(context, writer, "", reader);

    return writer.toString();
  }
}
