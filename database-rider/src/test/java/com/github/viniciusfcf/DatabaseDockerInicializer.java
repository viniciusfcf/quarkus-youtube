package com.github.viniciusfcf;

import java.util.HashMap;
import java.util.Map;

import org.testcontainers.containers.MariaDBContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public class DatabaseDockerInicializer implements QuarkusTestResourceLifecycleManager {

    private static MariaDBContainer<?> DATABASE = new MariaDBContainer<>();

    @Override
    public Map<String, String> start() {
    	System.out.println("---------------------DatabaseDockerInicializer.start()---------------------");
        DATABASE.start();
        return config();
    }

    private Map<String, String> config() {
        System.out.println("-------------DATABASE------------------");
        Map<String, String> config = new HashMap<>();
        config.put("quarkus.datasource.url", DATABASE.getJdbcUrl());
        config.put("quarkus.datasource.username", "root");
        config.put("quarkus.datasource.password", DATABASE.getPassword());
        System.out.println(config);
        System.out.println("-------------DATABASE------------------");
        return config;
    }

    @Override
    public void stop() {
        if (DATABASE != null) {
            DATABASE.close();
        }
    }
}