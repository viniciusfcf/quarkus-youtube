package com.github.viniciusfcf;

import io.quarkus.runtime.QuarkusApplication;

public class MeuQuarkusMain implements QuarkusApplication {

	@Override
	public int run(String... args) throws Exception {
        System.out.println("MeuQuarkusMain.run()");
		return 0;
	}
    
}