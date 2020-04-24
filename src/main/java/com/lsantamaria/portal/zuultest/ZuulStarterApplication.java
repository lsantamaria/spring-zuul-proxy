package com.lsantamaria.portal.zuultest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulStarterApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZuulStarterApplication.class, args);
  }

}
