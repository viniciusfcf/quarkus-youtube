package com.github.viniciusfcf.junit;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.github.viniciusfcf.restclient.Pet;
import com.github.viniciusfcf.restclient.PetService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class PetExternalService {

    @Inject
    @RestClient
    PetService petService;

	public List<Pet> findByStatus(String status) {
		return petService.findByStatus(status);
	}

    
}
