package com.github.viniciusfcf.hello.junit;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.github.viniciusfcf.junit.PetExternalService;
import com.github.viniciusfcf.restclient.Pet;

import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
public class MockPetExternalService extends PetExternalService {


    @Override
    public List<Pet> findByStatus(String status) {
        List<Pet> pets = new ArrayList<>();
        pets.add(new Pet(1L, "Animal Mock"));
        return pets;
    }

}