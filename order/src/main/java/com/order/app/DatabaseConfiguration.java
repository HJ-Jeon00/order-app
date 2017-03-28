package com.order.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.Properties;

import javax.sql.DataSource;

/**
 * Created by bryan.bernabe on 3/27/2017.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

  @Value("${db.driver}")
  private String dbDriver;

  @Value("${db.password}")
  private String dbPassword;

  @Value("${db.url}")
  private String dbUrl;

  @Value("${db.username}")
  private String dbUsername;

  @Value("${hibernate.dialect}")
  private String hibernateDialect;

  @Value("${hibernate.show_sql}")
  private String hibernateShowSql;

  @Value("${hibernate.hbm2ddl.auto}")
  private String hibernateHbm2DdlAuto;

  @Value("${entitymanager.packagesToScan}")
  private String entitymanagerPackagesToScan;

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(dbDriver);
    dataSource.setUrl(dbUrl);
    dataSource.setUsername(dbUsername);
    dataSource.setPassword(dbPassword);
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
    sessionFactoryBean.setDataSource(dataSource());
    sessionFactoryBean.setPackagesToScan(entitymanagerPackagesToScan);
    Properties hibernateProperties = new Properties();
    hibernateProperties.put("hibernate.dialect", hibernateDialect);
    hibernateProperties.put("hibernate.show_sql", hibernateShowSql);
    hibernateProperties.put("hibernate.hbm2ddl.auto", hibernateHbm2DdlAuto);
    sessionFactoryBean.setHibernateProperties(hibernateProperties);

    return sessionFactoryBean;
  }

  @Bean
  public HibernateTransactionManager transactionManager() {
    HibernateTransactionManager transactionManager =
      new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

}
