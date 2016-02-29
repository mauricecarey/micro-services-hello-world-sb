package com.prometheussoftwarellc.hello.configuration;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
  public SessionInitializer() {
    super(RedisConfig.class);
  }
}
