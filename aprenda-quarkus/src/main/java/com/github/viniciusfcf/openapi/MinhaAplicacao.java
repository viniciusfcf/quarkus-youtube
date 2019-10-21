package com.github.viniciusfcf.openapi;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@OpenAPIDefinition(info = @Info(description = "Conjunto endpoints utilizado para ensinar o quarkus.", title = "Aprenda quarkus", version = "0.0.1", contact = @Contact(name = "Vinicius", email = "vinicius.ferraz@gmail.com")))
public class MinhaAplicacao extends Application {

}