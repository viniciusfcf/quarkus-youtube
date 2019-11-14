package com.github.viniciusfcf.junit;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.viniciusfcf.restclient.Pet;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/animais")
@Tag(name = "animais")
public class AnimalResource {

    @Inject
    PetExternalService petExternalService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(description = "Busca os animais", summary = "Busca todos os animais cadastrados")
    @APIResponse(responseCode = "200")
    public List<Animal> buscarTodos() {
        return Animal.listAll();
    }

    @GET
    @Path("/{idAnimal}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Busca um animal pelo identificador")
    @APIResponse(responseCode = "200")
    @APIResponse(responseCode = "404")
    public Animal buscarUm(@PathParam("idAnimal") Long idAnimal) {
        Animal animal = Animal.findById(idAnimal);
        if (animal == null) {
            throw new NotFoundException();
        }
        return animal;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Cadastra um novo animal")
    @APIResponse(responseCode = "201")
    @Transactional
    public Animal cadastrarAnimal(CadastrarAnimalDTO dto) {
        Animal animal = new Animal();
        animal.setNome(dto.getNome());
        animal.setPeso(dto.getPeso());
        animal.persist();
        return animal;
    }

    @DELETE
    @Path("/{idAnimal}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Apaga um animal pelo identificador")
    @APIResponse(responseCode = "204")
    @Transactional
    public void apagar(@PathParam("idAnimal") Long idAnimal) {
        Animal.delete("id", idAnimal);
    }

    @PUT
    @Path("/{idAnimal}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Atualiza o animal")
    @APIResponse(responseCode = "200")
    @Transactional
    public Animal atualizar(@PathParam("idAnimal") Long idAnimal, AtualizarAnimalDTO dto) {
        Animal animal = Animal.findById(idAnimal);
        animal.setNome(dto.getNome());
        animal.persist();
        return animal;
    }

    @GET
    @Path("dados-externos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Busca animais disponíveis em um serviço externo ao nosso")
    @APIResponse(responseCode = "200")
    public List<Pet> buscarUmExterno() {
        return petExternalService.findByStatus("available");
    }
}