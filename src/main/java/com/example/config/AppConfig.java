package com.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@PropertySource("classpath:application.properties")
@Configuration
@ComponentScan
@EnableMongoRepositories(basePackages = {"com.example.db"})
public class AppConfig {

    @Value("${secret.key}")
    public String secretKey;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public String getPropertySecretKey() {
        return secretKey;
    }
}
