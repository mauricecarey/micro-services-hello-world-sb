package com.prometheussoftwarellc.hello.services;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prometheussoftwarellc.hello.model.Greeting;

/*
 * Based on code from https://spring.io/guides/gs/rest-service/
 */

@RestController
public class GreetingController {

  private static final String USER = "user";
  private static final String SESSION_COUNT = "count";
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name,
      HttpSession session) {
    if (session.getAttribute(USER) != null) {
      name = session.getAttribute(USER).toString();
    } else {
      session.setAttribute(USER, name);
    }
    final Long sessionCount;
    if (session.getAttribute(SESSION_COUNT) != null) {
      sessionCount = (Long)session.getAttribute(SESSION_COUNT) + 1;
    } else {
      sessionCount = Long.valueOf(1);
    }
    session.setAttribute(SESSION_COUNT, sessionCount);
    return new Greeting(counter.incrementAndGet(), sessionCount, String.format(template, name));
  }
}
