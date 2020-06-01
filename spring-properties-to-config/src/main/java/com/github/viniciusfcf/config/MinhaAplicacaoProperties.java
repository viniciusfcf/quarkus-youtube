package com.github.viniciusfcf.config;

import java.util.Optional;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.config.ConfigProperties;

// @ConfigurationProperties("minhaapp")
@ConfigProperties(prefix = "minhaapp")
// public class MinhaAplicacaoProperties {
public interface MinhaAplicacaoProperties {

    public String getNome();

    @ConfigProperty(name = "tamanho", defaultValue = "1")
    public Integer getTamanhoDoArquivo();

    public Optional<String> getDescricao();
    
}