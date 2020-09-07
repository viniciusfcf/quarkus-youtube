package com.github.viniciusfcf.aws.sns;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Path("/hello")
public class HelloResource {

    @Inject
    SnsClient client;

    @ConfigProperty(name = "topic.arn", defaultValue = "arn:aws:sns:us-east-1:323866915156:Quarkus")
    String topicArn;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@QueryParam("mensagem") String mensagem) {
        PublishResponse resposta = client.publish(p -> 
            p.message(mensagem)
            .topicArn(topicArn)
            .subject("Assunto da mensagem"));
        return "hello "+resposta.messageId();
    }
}