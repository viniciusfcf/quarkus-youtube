package com.github.viniciusfcf;

import java.util.Arrays;

import javax.inject.Inject;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class MeuMain implements QuarkusApplication {

    @Inject
    MeuServico servico;

	@Override
	public int run(String... args) throws Exception {
        System.out.println("Iniciando main");

        System.out.println(Arrays.toString(args));
        servico.facaAlgo();

		return 0;
	}
    
}