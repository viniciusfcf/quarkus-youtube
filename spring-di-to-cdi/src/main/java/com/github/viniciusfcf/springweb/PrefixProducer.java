package com.github.viniciusfcf.springweb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
//@Component
//@Repository
public class PrefixProducer {

    @Value("${produto.prefix}")
    String prefix;

    public String getPrefix() {
        return prefix;
    }
}