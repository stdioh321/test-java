package com.stdioh321.sboot.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Optional;

@Configuration
@EnableJpaRepositories(

        basePackages = "com.stdioh321.sboot.repositories.h2",
        entityManagerFactoryRef = "h2EntityManager",
        transactionManagerRef = "h2TransactionManager"


)
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
@PropertySource({"classpath:persistence-multiple-db.properties"})
public class DbH2Config {
    @Autowired
    private Environment env;

    @Bean
    public AuditorAware<String> auditorProvider() {

        return new AuditorAware<String>() {
            @Override
            public Optional<String> getCurrentAuditor() {
                return Optional.empty();
            }
        };
    }
    @Bean

    public LocalContainerEntityManagerFactoryBean h2EntityManager() {

        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(h2DataSource());
        em.setPackagesToScan(
                new String[]{"com.stdioh321.sboot.entities.h2"});

        HibernateJpaVendorAdapter vendorAdapter
                = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", env.getProperty("db.h2.hbm2ddl"));
        properties.put("hibernate.dialect", env.getProperty("db.h2.dialect"));
        em.setJpaPropertyMap(properties);

        return em;
    }


    @Bean
    public DataSource h2DataSource() {

        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("db.h2.driver"));
        dataSource.setUrl(env.getProperty("db.h2.url"));
        dataSource.setUsername(env.getProperty("db.h2.user"));
        dataSource.setPassword(env.getProperty("db.h2.pass"));

        return dataSource;
    }


    @Bean
    public PlatformTransactionManager h2TransactionManager() {

        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                h2EntityManager().getObject());
        return transactionManager;
    }
}
