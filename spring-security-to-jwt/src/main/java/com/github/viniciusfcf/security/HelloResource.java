package com.github.viniciusfcf.security;

import java.security.Principal;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;

@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Secured("admin")
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/pre1")
    @PreAuthorize("hasRole('admin')")
    public String hello1() {
        return "hello";
    }

    @GET
    @Path("/pre2")
    @PreAuthorize("hasAnyRole('admin')")
    public String hello2() {
        return "hello";
    }

    @GET
    @Path("/pre3")
    @PreAuthorize("permitAll()")
    public String hello3() {
        return "hello";
    }

    @GET
    @Path("/pre4")
    @PreAuthorize("denyAll()")
    public String hello4() {
        return "hello";
    }

    @GET
    @Path("/pre5")
    @PreAuthorize("isAnonymous()")
    public String hello5() {
        return "hello";
    }

    @GET
    @Path("/pre6")
    @PreAuthorize("isAuthenticated()")
    public String hello6() {
        return "hello";
    }

    @GET
    @Path("/pre7/{username}")
    @PreAuthorize("#username == authentication.principal.username")
    public String hello4(@PathParam("username") String username) {
        return "hello";
    }
}