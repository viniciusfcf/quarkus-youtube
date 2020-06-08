package com.github.viniciusfcf.springdata;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;

import io.quarkus.panache.common.Page;

@Path("/frutas")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
@ApplicationScoped
public class FrutaResource {

    // private final FrutaRepository frutaRepository;

    //Precisava apenas com Repository
    // @Inject
    // public FrutaResource(FrutaRepository frutaRepository) {
    //     this.frutaRepository = frutaRepository;
    // }

    @GET
    public Iterable<Fruta> findAll() {
        // return frutaRepository.findAll();
        return Fruta.listAll();
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam long id) {
        Fruta.deleteById(id);
    }

    @POST
    @Path("/nome/{nome}/cor/{cor}")
    public Fruta criar(@PathParam String nome, @PathParam String cor) {
        // return frutaRepository.save(new Fruta(nome, cor));
        Fruta entity = new Fruta();
        entity.cor = cor;
        entity.nome = nome;
        entity.persist();
        return entity;
    }

    @PUT
    @Path("/id/{id}/cor/{cor}")
    public Fruta alterarCor(@PathParam Long id, @PathParam String cor) {
        Optional<Fruta> optional = Fruta.findByIdOptional(id);
        if (optional.isPresent()) {
            Fruta fruta = optional.get();
            fruta.cor = cor;
            fruta.persist();
            return fruta;
        }

        throw new NotFoundException("Fruta com id " + id + " não existe");
    }

    @GET
    @Path("/cor/{cor}")
    public List<Fruta> findByColor(@PathParam String cor) {
        return Fruta.findByCor(cor);
    }

    @GET
    @Path("/cor/ordenado/{cor}")
    public List<Fruta> findByColorOrdenado(@PathParam String cor) {
        return Fruta.findByCorOrderByNome(cor);
    }

    @GET
    @Path("/nome/{nome}")
    public List<Fruta> findByNome(@PathParam String nome) {
        return Fruta.nome(nome);
    }

    @GET
    @Path("/{id}")
    public Fruta findById(@PathParam Long id) {
        return Fruta.findByIdentificador(id);
    }

    @GET
    @Path("paginado")
    public List<Fruta> findOrderByNome(@QueryParam Integer page, @QueryParam Integer size) {
        // Pageable pageable = PageRequest.of(page, size);
        Page pageable = Page.of(page, size);
        return Fruta.orderByNome(pageable);
    }


    @DELETE
    @Path("/nome/{nome}")
    public Long deleteByNomeLike(@PathParam String nome) {
        return Fruta.deleteByNomeLike(nome);
    }
}