package com.github.viniciusfcf.hello.junit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;

import com.github.viniciusfcf.junit.Animal;
import com.github.viniciusfcf.junit.AtualizarAnimalDTO;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class AnimalResourceTest {


    @Test
    public void testGetAll() {
        given()
        .when().get("/animais")
        .then()
        .statusCode(200)
        
        .body("size()", is(2), "nome", hasItems("Bode", "Cachorro"), "id", hasItems(1, 2));
    }

    @Test
    public void testPut() {
        AtualizarAnimalDTO dto = new AtualizarAnimalDTO();
        dto.setNome("Jumento");
        given()
        .pathParam("idAnimal", 1)
        .contentType(ContentType.JSON)
        .body(dto)
        .when().put("/animais/{idAnimal}")
        .then()
        .statusCode(200)
        
        .body("nome", is("Jumento"), "peso", anything());

    }

    @Test
    public void testGetDadosExternos() {
        given()
        .when().get("/animais/dados-externos")
        .then()
        .statusCode(200)
        
        .body("size()", is(1), "[0].name", is("Animal Mock"));
    }

    /*
        allOf
        anyOf
        anything
        containsStringignoringCase
        is
        isA
        not
        
    */
}