package com.github.viniciusfcf.migracoes;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class AgoraEhCLI implements QuarkusApplication {

	@Override
	public int run(String... args) throws Exception {
        System.out.println("AgoraEhCLI.run()");
        Quarkus.waitForExit();
		return 0;
	}
    
}