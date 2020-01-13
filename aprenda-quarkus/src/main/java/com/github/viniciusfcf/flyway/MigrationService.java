package com.github.viniciusfcf.flyway;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import org.jboss.logging.Logger;

import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class MigrationService {
    
    private static final Logger LOGGER = Logger.getLogger(MigrationService.class);
    

    // You can Inject the object if you want to use it manually
    // COMENTADO devivo ao bug com graylog: https://github.com/quarkusio/quarkus/issues/6434
    // @Inject
    // Flyway flyway; 
    

    void onStart(@Observes StartupEvent ev) {    
        //Desabilitei no video 18...

        LOGGER.info("Inicializando MigrationService...");
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