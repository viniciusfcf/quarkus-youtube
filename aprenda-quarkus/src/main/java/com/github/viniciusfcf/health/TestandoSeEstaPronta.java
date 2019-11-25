package com.github.viniciusfcf.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;
import org.flywaydb.core.Flyway;

@Readiness
@ApplicationScoped
public class TestandoSeEstaPronta implements HealthCheck {


	@Inject
    Flyway flyway; 
   

	@Override
	public HealthCheckResponse call() {
		int quantidadePendencias = flyway.info().pending().length;
		boolean temPendencia = quantidadePendencias > 0;
		HealthCheckResponseBuilder health = HealthCheckResponse.named("Verificando se banco está com pendência").up();
		if (temPendencia) {
			health.down().withData("pendencias", quantidadePendencias);
		}
		return health.build();
	}

}
