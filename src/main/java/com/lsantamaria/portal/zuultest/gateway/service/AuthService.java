package com.lsantamaria.portal.zuultest.gateway.service;

import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Mock auth service that models an external authentication call.
 */
@Service
@Slf4j
public class AuthService {

  public String performAuthentication(String username, String password) {
    log.info("Authenticating user " + username + "and password " + password);
    return UUID.randomUUID().toString();
  }
}
