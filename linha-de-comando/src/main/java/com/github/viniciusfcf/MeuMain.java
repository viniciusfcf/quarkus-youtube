package com.github.viniciusfcf;

import java.util.Arrays;

import javax.inject.Inject;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MeuMain implements QuarkusApplication {

    @Inject
    @Channel("nome-canal")
    Emitter<String> emitter;

	@Override
	public int run(String... args) throws Exception {
        System.out.println("Iniciando main");

        Arrays.stream(args).forEach(emitter::send);

		return 0;
	}
    
}