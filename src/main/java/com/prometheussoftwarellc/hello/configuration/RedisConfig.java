package com.prometheussoftwarellc.hello.configuration;

import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

@Configuration
@EnableRedisHttpSession
@ConfigurationProperties(prefix="spring.redis")
@Setter
public class RedisConfig {
  private String host = "localhost";
  private String port = "6379";

  @Bean
  public JedisConnectionFactory connectionFactory() {
    final JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    jedisConnectionFactory.setHostName(host);
    jedisConnectionFactory.setPort(Integer.parseInt(port));
    return jedisConnectionFactory;
  }

  @Bean
  public HttpSessionStrategy httpSessionStrategy() {
    return new HeaderHttpSessionStrategy();
  }
}
