package com.github.viniciusfcf.keycloak;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlow;
import org.eclipse.microprofile.openapi.annotations.security.OAuthFlows;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;

import io.quarkus.security.identity.SecurityIdentity;

@Path("/computadores")
@SecurityScheme(securitySchemeName = "quarkus-oauth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(password = @OAuthFlow(tokenUrl = "http://localhost:8180/auth/realms/quarkus/protocol/openid-connect/token")))
public class ComputadoresResource {

    @Inject
    SecurityIdentity identity;

    @GET
    @Path("publico")
    @Produces(MediaType.TEXT_PLAIN)
    public String methodname() {
        return "hello publico";
    }

    @GET
    @Path("protegido")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("user")
    @SecurityRequirement(name = "quarkus-oauth")
    public String protegido() {
        return "hello protegido "+identity.getPrincipal().getName();
    }
}