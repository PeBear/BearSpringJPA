package com.bear.bearspring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeController {

  @GetMapping(path = {"/"})
  public String dashboard() {
    boolean authenticated = SecurityContextHolder.getContext().getAuthentication().isAuthenticated();
    if (!authenticated) {
      return "login";
    }
    return "index";
  }

  @GetMapping(path = "/login")
  public String login() {
    return "login";
  }
}
