package com.github.viniciusfcf.config;

import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

@ConfigProperties(prefix = "sistema")
public class ConfiguracoesSistema {

    @ConfigProperty(name = "propriedade1")
    String propriedade1;

    @ConfigProperty(name = "propriedade2")
    Optional<Integer> propriedade2;

    public String getPropriedade1() {
        return propriedade1;
    }

    public void setPropriedade1(String propriedade1) {
        this.propriedade1 = propriedade1;
    }

    public Optional<Integer> getPropriedade2() {
        return propriedade2;
    }

    public void setPropriedade2(Optional<Integer> propriedade2) {
        this.propriedade2 = propriedade2;
    }


}