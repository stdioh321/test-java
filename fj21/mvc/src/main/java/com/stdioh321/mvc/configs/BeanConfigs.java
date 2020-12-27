package com.stdioh321.mvc.configs;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableTransactionManagement
public class BeanConfigs {

    @Value("${db.mysql.host}") String mysqlHost;
    @Value("${db.mysql.user}") String mysqlUser;
    @Value("${db.mysql.pass}") String mysqlPass;

    @PersistenceContext(unitName = "pu-mysql")
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
        System.out.println("----- LocalContainerEntityManagerFactoryBean -----");
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("pu-mysql");
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setDataSource(this.dataSourceMySql());

        factoryBean.setPackagesToScan("com.stdioh321.mvc.entities");
        return factoryBean;
    }
    @Bean(name = "dSourceMySql")
    public DataSource dataSourceMySql() {
        System.out.println("---- dataSourceMySql ----");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(mysqlHost);
        dataSource.setUsername(mysqlUser);
        dataSource.setPassword(mysqlPass);
        return dataSource;
    }


    @Bean(name = "dSourceMysqlTransaction")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(localContainerEntityManagerFactoryBean().getObject());
        return txManager;
    }


    @PersistenceContext(unitName = "pu-sqlite")
    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBeanSqlite() {
        System.out.println("----- LocalContainerEntityManagerFactoryBean -----");
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPersistenceUnitName("pu-sqlite");
        JpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(adapter);
        factoryBean.setDataSource(this.dataSourceSqlite());

        factoryBean.setPackagesToScan("com.stdioh321.mvc.entities");
        return factoryBean;
    }
    @Bean(name = "dSourceSqlite")
    public DataSource dataSourceSqlite() {
        System.out.println("---- dataSourceSqlite ----");
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.sqlite.JDBC");
        dataSource.setUrl("jdbc:sqlite:sqlite_db.db");
        dataSource.setUsername("");
        dataSource.setPassword("");
        return dataSource;
    }


    @Bean(name = "dSourceSqliteTransaction")
    public JpaTransactionManager transactionManagerSqlite() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(localContainerEntityManagerFactoryBeanSqlite().getObject());
        return txManager;
    }
}
