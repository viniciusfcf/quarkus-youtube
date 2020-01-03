package com.github.viniciusfcf.flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class MigrationService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger("MigrationService");

    // You can Inject the object if you want to use it manually
    @Inject
    Flyway flyway; 
    

    void onStart(@Observes StartupEvent ev) {    
        //Desabilitei no video 18...
        
        LOGGER.info("Inicializando BD com Flyway...");
        // flyway.clean();
        // flyway.migrate();
        // MigrationInfo current = flyway.info().current();
        // if(current != null) {
        //     LOGGER.info(current.getVersion().getVersion());
        //     LOGGER.info(current.getState().toString());
        // }else {
        //     LOGGER.info("SEM VERSÃO DE FLYWAY");
        // }
        
    }
}