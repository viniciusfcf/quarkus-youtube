package com.github.viniciusfcf.route;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.RouteBase;
import io.quarkus.vertx.web.RoutingExchange;
import io.vertx.ext.web.RoutingContext;

@ApplicationScoped
@RouteBase(path = "padrao")
public class HelloReativoResource {

    @Route(path = "h1")
    @Route(path = "h2")
    public void hello1(RoutingContext rc) {
        rc.response().end("hello1");
    }

    @Route
    public void hello2(RoutingExchange re) {
        re.ok("hello2");
    }
}