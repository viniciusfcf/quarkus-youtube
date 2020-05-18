package com.github.viniciusfcf.springweb;

import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

// @Service
//@Component
//@Repository
@Singleton
public class PrefixProducer {

    // @Value("${produto.prefix}")
    @ConfigProperty(name="produto.prefix")
    String prefix;

    public String getPrefix() {
        return prefix;
    }
}