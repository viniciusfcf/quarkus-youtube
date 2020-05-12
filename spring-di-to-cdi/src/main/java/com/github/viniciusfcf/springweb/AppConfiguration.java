package com.github.viniciusfcf.springweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    
    @Bean(name = "upperCaseFunction")
    public StringFunction capitalizer() {
        return String::toUpperCase;
    }
}