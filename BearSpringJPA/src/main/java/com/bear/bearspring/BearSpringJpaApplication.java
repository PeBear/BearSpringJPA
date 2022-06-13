package com.bear.bearspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bear.bearspring.repository")
@EntityScan(basePackages = "com.bear.bearspring.domain")
public class BearSpringJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(BearSpringJpaApplication.class, args);
  }

}
