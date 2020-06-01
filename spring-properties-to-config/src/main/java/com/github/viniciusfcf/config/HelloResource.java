package com.github.viniciusfcf.config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class HelloResource {

    @Inject
    MinhaAplicacaoProperties properties;
    
    @ConfigProperty(name = "configuracao-externa", defaultValue="hello default")
    String conf;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "nome: "+properties.getNome()+". Tamanho: "+properties.getTamanhoDoArquivo()+
        ". Descrição: "+properties.getDescricao()+". Conf: "+conf;
    }
}