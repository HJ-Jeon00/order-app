package com.order.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by bryan.bernabe on 11/9/2016.
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigApplication extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(ConfigApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(ConfigApplication.class);
  }
}

