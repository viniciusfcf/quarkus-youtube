package com.github.viniciusfcf.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class TestandoSeEstaPronta implements HealthCheck {


	// @Inject
    // Flyway flyway; 
   

	@Override
	public HealthCheckResponse call() {
		// int quantidadePendencias = flyway.info().pending().length;
		//Comentado no video 19, flyway tem bug com graylog.
		int quantidadePendencias = 0;
		boolean temPendencia = quantidadePendencias > 0;
		HealthCheckResponseBuilder health = HealthCheckResponse.named("Verificando se banco está com pendência").up();
		if (temPendencia) {
			health.down().withData("pendencias", quantidadePendencias);
		}
		return health.build();
	}

}
