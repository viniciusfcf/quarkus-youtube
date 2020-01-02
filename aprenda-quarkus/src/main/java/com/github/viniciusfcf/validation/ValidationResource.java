package com.github.viniciusfcf.validation;

import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.validation.constraints.Max;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

@Path("/validations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ValidationResource {

    @Inject
    Validator validator;

    @Inject
    ValidationService service;

    @GET
    @Path("/query")
    public void query(@QueryParam("i") @Max(10) Integer i) {
        
    }

    @POST
    @Path("/annotation")
    public void annotation(@RequestBody @Valid DTOExemplo dto) {
        
    }

    @POST
    @Path("/service")
    public void service(@RequestBody DTOExemplo dto) {
        service.fazAlgo(dto);
    }

    @POST
    @Path("/manual")
    public void manual(@RequestBody DTOExemplo dto) {
        Set<ConstraintViolation<DTOExemplo>> violations = validator.validate(dto);
        if(violations.isEmpty()) {
            System.out.println("OK");
        }else {
            System.out.println(violations);
        }
    }

    @POST
    @Path("/manual2")
    public void manual2(@RequestBody DTOExemplo dto) throws MinhaValidacaoException {
        Set<ConstraintViolation<DTOExemplo>> violations = validator.validate(dto);
        if(violations.isEmpty()) {
            System.out.println("OK");
        }else {
            throw new MinhaValidacaoException(violations);
        }
    }

}

