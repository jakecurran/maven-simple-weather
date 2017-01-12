package com.jakecurran.mavenbook.weather;

import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import org.apache.log4j.Logger;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.VelocityContext;

public class WeatherFormatter {
  private static Logger log = Logger.getLogger(WeatherFormatter.class);

  public String format(Location location, Weather weather) throws Exception {
    log.info("\tWeatherFormatter.format()");

    log.info("\t\tRead output format from 'output.vm' resource");
    Reader reader = new InputStreamReader(
      getClass().getClassLoader().getResourceAsStream("output.vm")
    );

    log.info("Create VelocityContext using Location and Weather objects");
    VelocityContext context = new VelocityContext();
    context.put("location", location);
    context.put("weather", weather);

    log.info("Call on Velocity to compute formatted output");
    StringWriter writer = new StringWriter();
    Velocity.evaluate(context, writer, "", reader);

    log.info("RETURN: formatted weather report as String");
    return writer.toString();
  }
}
