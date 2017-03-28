package com.order.app;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */

import com.google.common.base.Predicates;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by 177294 on 9/8/2016.
 */
@Configuration
@Profile("!production")
@EnableSwagger2
public class SwaggerConfiguration {

  @Bean
  public Docket flightsDetailApi() {
    return new Docket(DocumentationType.SWAGGER_2)
      .apiInfo(this.orderAppInfo())
      .select()
      .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
      .build();

  }

  private ApiInfo orderAppInfo() {
    return new ApiInfoBuilder()
      .title("Order App - build# 0.1")
      .description("Order your starbucks!")
      .version("0.1")
      .build();
  }
}
