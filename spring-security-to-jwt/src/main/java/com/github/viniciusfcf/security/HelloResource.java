package com.github.viniciusfcf.security;

import java.security.Principal;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.security.Authenticated;


@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // @Secured("admin")
    @RolesAllowed("admin")
    public String hello() {
        return "hello";
    }

    @GET
    @Path("/pre1")
    // @PreAuthorize("hasRole('admin')")
    @RolesAllowed("admin")
    public String hello1() {
        return "hello";
    }

    @GET
    @Path("/pre2")
    // @PreAuthorize("hasAnyRole('admin')")
    @RolesAllowed({"admin", "gestor"})
    public String hello2() {
        return "hello";
    }

    @GET
    @Path("/pre3")
    // @PreAuthorize("permitAll()")
    @PermitAll
    public String hello3() {
        return "hello";
    }

    @GET
    @Path("/pre4")
    // @PreAuthorize("denyAll()")
    @DenyAll
    public String hello4() {
        return "hello";
    }

    @GET
    @Path("/pre6")
    // @PreAuthorize("isAuthenticated()")
    @Authenticated // Poderia ser: RolesAllowed("**")
    public String hello6() {
        return "hello";
    }

    @GET
    @Path("/pre5")
    // @PreAuthorize("isAnonymous()")
    //Não conseguimos somente uma notação
    public String hello5() {
        return "hello";
    }

    @GET
    @Path("/pre7/{username}")
    // @PreAuthorize("#username == authentication.principal.username")
    //Não conseguimos somente uma notação
    public String hello4(@PathParam("username") String username) {
        return "hello";
    }
}