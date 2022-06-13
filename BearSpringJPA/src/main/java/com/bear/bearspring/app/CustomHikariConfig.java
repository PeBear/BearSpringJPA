package com.bear.bearspring.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.datasource.hikari")
public class CustomHikariConfig extends HikariConfig {

  private static final Logger LOG = LoggerFactory.getLogger(CustomHikariConfig.class);

  @Bean
  public DataSource dataSource() {
    LOG.info("dataSource - loads the Hikari datasource properties");
    return new HikariDataSource(this);
  }

}
