package com.bear.bearspring.controller;

import com.bear.bearspring.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HomeApiController {

  private final ConfigurationService configurationService;

  @GetMapping("/api/v1/reloadConfig")
  public String reloadConfig() {
    configurationService.reloadConfiguration();
    return "success";
  }
}
