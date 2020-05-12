package com.github.viniciusfcf.springweb;

import org.springframework.stereotype.Component;

@Component("noopFunction")
public class NoOpStringFunction implements StringFunction {

    @Override
    public String apply(String s) {
        return s;
    }
}