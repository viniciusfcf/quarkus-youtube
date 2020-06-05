package com.github.viniciusfcf.springdata;

import java.util.List;
import java.util.Optional;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
public class FrutaResource {

    private final FrutaRepository frutaRepository;

    public FrutaResource(FrutaRepository frutaRepository) {
        this.frutaRepository = frutaRepository;
    }

    @GET
    public Iterable<Fruta> findAll() {
        return frutaRepository.findAll();
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam long id) {
        frutaRepository.deleteById(id);
    }

    @POST
    @Path("/nome/{nome}/cor/{cor}")
    public Fruta create(@PathParam String nome, @PathParam String cor) {
        return frutaRepository.save(new Fruta(nome, cor));
    }

    @PUT
    @Path("/id/{id}/cor/{cor}")
    public Fruta changeColor(@PathParam Long id, @PathParam String cor) {
        Optional<Fruta> optional = frutaRepository.findById(id);
        if (optional.isPresent()) {
            Fruta fruta = optional.get();
            fruta.setCor(cor);
            return frutaRepository.save(fruta);
        }

        throw new NotFoundException("Fruta com id " + id + " não existe");
    }

    @GET
    @Path("/cor/{cor}")
    public List<Fruta> findByColor(@PathParam String cor) {
        return frutaRepository.findByCor(cor);
    }
}