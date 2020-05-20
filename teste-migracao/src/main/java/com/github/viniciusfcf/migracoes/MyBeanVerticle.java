package com.github.viniciusfcf.migracoes;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class MyBeanVerticle {

    public void onStart2(@Observes io.vertx.ext.web.Router router) {
		router.get("/my-route").handler(rc -> rc.response().end("Hello from my route"));
	}

}