package com.order.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@SpringBootApplication
public class OrderApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(OrderApplication.class, args);
  }

  @Override
  /**
   * This method works with the dependencies -> providedRuntime (embedded classpath pkg server) on
   * Gradle or Maven, where the jars for the embedded server are stored under WEB-INF/lib-provided
   */
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(OrderApplication.class);
  }
}
