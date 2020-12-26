package com.stdioh321.mvc.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration


public class BeanConfigs{




    /*@Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(DataSource dataSource) {
        System.out.println("----- LocalContainerEntityManagerFactoryBean -----");
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setDataSource(dataSource);

        factoryBean.setPackagesToScan("com.stdioh321.mvc.entities");
        return factoryBean;
    }

    @Bean(name="dSourceMySql")
    public DataSource dataSourceMySql() {
        System.out.println("---- dataSourceMySql ----");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/fj21");
        dataSource.setUsername("root");
        dataSource.setPassword("includestdioh");
        return dataSource;
    }*/
}