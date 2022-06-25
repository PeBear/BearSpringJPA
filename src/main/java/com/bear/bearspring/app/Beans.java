package com.bear.bearspring.app;

import java.util.Locale;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class Beans {

  @Value("${rest-template.connection.timeout}")
  private int connectionTimeout;

  @Value("${rest-template.read.timeout}")
  private int readTimeout;

//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return new BCryptPasswordEncoder();
//        }

  /**
   * Initializes the wrapper of {@code RestTemplate}
   *
   * @return a {@link RestTemplateExt}
   */
  @Bean
  public RestTemplateExt restTemplateExt() {
    return new RestTemplateExt(
        CustomSSLSocketFactory.createClientHttpRequestFactory(connectionTimeout, readTimeout));
  }

  /**
   * Introduce a Tiles view resolver, this is a convenience implementation that extends URLBasedViewResolver.
   *
   * @return tiles view resolver
   */
  @Bean
  public TilesViewResolver tilesViewResolver() {
    final TilesViewResolver resolver = new TilesViewResolver();
    resolver.setViewClass(TilesView.class);
    return resolver;
  }

  @Bean
  public TilesConfigurer tilesConfigurer() {
    TilesConfigurer tilesConfigurer = new TilesConfigurer();
    String[] defs = {"WEB-INF/tiles.xml"};
    tilesConfigurer.setDefinitions(defs);
    return tilesConfigurer;
  }

  @Bean
  public LocaleResolver localeResolver() {
    SessionLocaleResolver slr = new SessionLocaleResolver();
    slr.setDefaultLocale(Locale.US);
    return slr;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
    messageSource.setBasename("classpath:messages");
    messageSource.setCacheSeconds(-1); // reload messages every 10 seconds
    return messageSource;
  }
}
