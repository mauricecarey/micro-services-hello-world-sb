package com.prometheussoftwarellc.hello.model;

import lombok.Value;

/*
 * Based on code from https://spring.io/guides/gs/rest-service/
 */

@Value
public class Greeting {
  private final long id;
  private final String content;
}
