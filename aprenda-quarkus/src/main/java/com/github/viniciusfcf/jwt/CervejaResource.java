package com.github.viniciusfcf.jwt;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/cervejas")
public class CervejaResource {


    @Inject
    JsonWebToken token;

    @Inject
    @Claim(standard = Claims.sub)
    String sub;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // @Authenticated
    @RolesAllowed("Funcionario")
    public String methodname() {
        System.out.println("-----------------------AA--------");
        System.out.println(token.getRawToken());
        System.out.println(sub);
        return "Heineken";
    }
}