package com.github.viniciusfcf.springweb;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.Produces;

// @Configuration
@ApplicationScoped // @Singleton ou @Dependent
public class AppConfiguration {
    
    // @Bean(name = "upperCaseFunction")
    @Produces
    @Named("upperCaseFunction")
    public StringFunction capitalizer() {
        return String::toUpperCase;
    }
}