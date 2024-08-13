package com.dogukan;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;

@PropertySource("classpath:db.properties")
//data base ayarlamalarını kaynak uzerinden yaptık ve o kaynagı okumak icin bir kaynak okuyucuya ihtiyacimiz var
@Configuration
public class RootConfig {
    //JDBC ve Hibernate
    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource();
        sessionFactory.setHibernateProperties();
        sessionFactory.setPackagesToScan(new String[]{"com.dogukan.domain"});//entity'lerin arandigi yer
        return sessionFactory;
    }

    private DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
    }
}
