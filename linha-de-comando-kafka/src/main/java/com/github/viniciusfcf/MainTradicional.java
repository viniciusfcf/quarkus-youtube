package com.github.viniciusfcf;

import io.quarkus.runtime.Quarkus;

public class MainTradicional {
    
    public static void main(String[] args) {
        Quarkus.run(MeuQuarkusMain.class, args);
    }

}