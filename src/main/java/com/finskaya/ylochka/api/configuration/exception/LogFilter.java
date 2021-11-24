package com.finskaya.ylochka.api.configuration.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.firewall.RequestRejectedException;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Alexandr Stegnin
 */

@Slf4j
public class LogFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    try {
      chain.doFilter(request, response);
    } catch (RequestRejectedException e) {
      log.trace("Произошла ошибка RequestRejectedException...");
      log.trace("Запрашиваемый URL: {}", request.getLocalAddr());
      throw e;
    } catch (Exception e) {
      log.error(e.getLocalizedMessage());
    }
  }
}
