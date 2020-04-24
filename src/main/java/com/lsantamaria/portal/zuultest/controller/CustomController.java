package com.lsantamaria.portal.zuultest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A custom controller. The requests received in this endpoint are not proxied by Zuul.
 */
@RestController
public class CustomController {

  @GetMapping("/custom")
  public String customController() {
    return "This request is not proxied";
  }
}
