package com.springmvc.todos.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by novy on 31.10.14.
 */
@Configuration
@ComponentScan("com.springmvc.todos")
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class WebAppConfig {
    private static final String DATABASE_DRIVER = "database.driver";
    private static final String DATABASE_URL = "database.url";
    private static final String DATABASE_USERNAME = "database.username";
    private static final String DATABASE_PASSWORD = "database.password";

    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_HBN2DDL_AUTO = "hibernate.hbm2ddl.auto";

    private static final String ENTITY_MANAGER_PACKAGES_TO_SCAN = "entity.manager.packages.to.scan";
    private static final String URL_RESOLVER_PREFIX = "/WEB-INF/pages/";
    private static final String URL_RESOLVER_SUFFIX = ".jsp";

    @Resource
    private Environment environment;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(environment.getRequiredProperty(DATABASE_DRIVER));
        dataSource.setUrl(environment.getRequiredProperty(DATABASE_URL));
        dataSource.setUsername(environment.getRequiredProperty(DATABASE_USERNAME));
        dataSource.setPassword(environment.getRequiredProperty(DATABASE_PASSWORD));

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();

        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan(environment.getRequiredProperty(ENTITY_MANAGER_PACKAGES_TO_SCAN));
        sessionFactoryBean.setHibernateProperties(hibernateProperties());

        return sessionFactoryBean;
    }

    public Properties hibernateProperties() {
        Properties properties = new Properties();

        properties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
        properties.put(HIBERNATE_HBN2DDL_AUTO, environment.getRequiredProperty(HIBERNATE_HBN2DDL_AUTO));

        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    @Bean
    UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

        viewResolver.setPrefix(URL_RESOLVER_PREFIX);
        viewResolver.setSuffix(URL_RESOLVER_SUFFIX);
        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

}