package com.github.viniciusfcf.config;

import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;

public class MeuConfigSource implements ConfigSource {

    Map<String, String> propriedades = Map.of("configuracao-externa", "Valor do Spring");

	@Override
	public Map<String, String> getProperties() {
		return propriedades;
	}

	@Override
	public String getValue(String propertyName) {
		return propriedades.get(propertyName);
	}

	@Override
	public String getName() {
		return "nome legal";
	}
    
}