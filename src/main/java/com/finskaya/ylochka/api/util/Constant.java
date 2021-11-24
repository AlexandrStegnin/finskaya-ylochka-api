package com.finskaya.ylochka.api.util;

import lombok.experimental.UtilityClass;

/**
 * @author Alexandr Stegnin
 */
@UtilityClass
public class Constant {

  // Security
  public static final String AUTHORITIES_KEY = "authorities";

  public static final String API_INFO_URL = "/swagger-ui.html";

  public static final String BASE_URL = "/";

  public static final String ROLE_PREFIX = "ROLE_";

  public static final String INVALID_APP_TOKEN = "Неверный ключ приложения.";

  // API PATHS
  public static final String[] API_HTTP_MATCHERS = {
      "/api/v1/**"
  };

  // IGNORING access to Spring Security

  public static final String[] ALL_HTTP_MATCHERS = {
      "/VAADIN/**", "/HEARTBEAT/**", "/UIDL/**", "/resources/**",
      "/manifest.json", "/icons/**", "/images/**",
      // (development mode) static resources
      "/frontend/**",
      // (development mode) webjars
      "/webjars/**",
      // (development mode) H2 debugging console
      "/h2-console/**",
      // (production mode) static resources
      "/frontend-es5/**", "/frontend-es6/**"
  };

  public static final String[] ALL_SWAGGER_MATCHERS = {"/v3/api-docs*", "/configuration/**", "/swagger*/**", "/webjars/**", "/", "/info"};

}
