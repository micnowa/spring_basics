package com.example.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:databases/database.properties")
@PropertySource("classpath:application.properties")
@Data
public class PropertiesConfig {
    @Value("${host}")
    private String host;

}
