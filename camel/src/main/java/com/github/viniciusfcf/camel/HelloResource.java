package com.github.viniciusfcf.camel;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.camel.ProducerTemplate;

@Path("/hello")
public class HelloResource {

    @Inject
    ProducerTemplate producer;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello( @QueryParam("nome") String nome) {
        producer.sendBody("slack:#teste-para-o-canal?"+
        "webhookUrl=https://hooks.slack.com/services/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"
        +"&iconEmoji=:ghost:"
        , 
        "Enviando mensagem do Quarkus: "+nome);

        return "hello";
    }
}