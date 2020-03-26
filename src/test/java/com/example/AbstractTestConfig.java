package com.example;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@PropertySource("classpath:application.properties")
public abstract class AbstractTestConfig {

    @Value("${secret.key}")
    public String SECRET_KEY;
}
