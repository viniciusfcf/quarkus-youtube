package com.github.viniciusfcf.springweb;

import javax.inject.Named;
import javax.inject.Singleton;

// @Component("noopFunction")
@Singleton
@Named("noopFunction")
public class NoOpStringFunction implements StringFunction {

    @Override
    public String apply(String s) {
        return s;
    }
}