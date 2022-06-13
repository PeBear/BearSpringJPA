package com.bear.bearspring.app;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataSourceAdapter {

  @Autowired
  private Environment environment;

  //  @Bean
//  public Connection getConnection() throws SQLException {
//    return initDataSource(moduleConfig).getConnection();
//  }
//
//  @Bean
//  public DataSource initDataSource() throws Exception {
//    HikariConfig hikariConfig = new HikariConfig();
//    hikariConfig.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
//    hikariConfig.setJdbcUrl(environment.getProperty("spring.datasource.url"));
//    hikariConfig.setUsername(environment.getProperty("spring.datasource.username"));
//    hikariConfig.setPassword(environment.getProperty("spring.datasource.password"));
//    hikariConfig.setConnectionTimeout(10000);
//    hikariConfig.setAutoCommit(true);
//    hikariConfig.setMaximumPoolSize(20);
//    hikariConfig.setMinimumIdle(10);
//    log.info("Init connection to db success");
//    return new HikariDataSource(hikariConfig);
//  }

//  @Bean
//  public SessionFactory getSessionFactory() {
//    StandardServiceRegistry registry = null;
//    SessionFactory sessionFactory = null;
//    DatabaseConfig config = bearConfig.getDatabaseConfig();
//    try {
//
//      StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
//
//      Map<String, Object> settings = new HashMap<>();
//      settings.put(Environment.DRIVER, config.getClassDriver());
//      settings.put(Environment.URL, config.getUrl());
//      String username = PasswordCrypter.decrypt(config.getUsername());
//      settings.put(Environment.USER, username);
//      String password = PasswordCrypter.decrypt(config.getPassword());
//      settings.put(Environment.PASS, password);
//      settings.put(Environment.SHOW_SQL, true);
//
//      // HikariCP settings
//
//      // Maximum waiting time for a connection from the pool
//      settings.put("hibernate.hikari.connectionTimeout", "10000");
//      // Minimum number of ideal connections in the pool
//      settings.put("hibernate.hikari.minimumIdle", "10");
//      // Maximum number of actual connection in the pool
//      settings.put("hibernate.hikari.maximumPoolSize", "20");
//      // Maximum time that a connection is allowed to sit ideal in the pool
//      settings.put("hibernate.hikari.idleTimeout", "30000");
//      registryBuilder.applySettings(settings);
//
//      registry = registryBuilder.build();
//      MetadataSources sources = new MetadataSources(registry);
//      this.annotatedClass(sources);
//      Metadata metadata = sources.getMetadataBuilder().build();
//      sessionFactory = metadata.getSessionFactoryBuilder().build();
//    } catch (Exception e) {
//      if (registry != null) {
//        StandardServiceRegistryBuilder.destroy(registry);
//      }
//      log.error("Init SessionFactory error: {}", e.getMessage());
//      System.exit(1);
//    }
//
//    return sessionFactory;
//  }

//  private void annotatedClass(MetadataSources sources) {
//    Reflections reflections = new Reflections("vn.bear.system.Maps");
//
//    Set<Class<?>> classes = reflections.getTypesAnnotatedWith(javax.persistence.Entity.class);
//
//    for (Class<?> clazz : classes) {
//      sources.addAnnotatedClass(clazz);
//    }
//  }

//  @Bean(name = "transactionManager")
//  public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
//    HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
//    return transactionManager;
//  }
}
