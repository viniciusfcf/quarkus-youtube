package com.github.viniciusfcf.hello.junit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.github.viniciusfcf.junit.AtualizarAnimalDTO;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AnimalResourceTest {


    @Test
    @Order(1)
    public void testGetAll() {
        given()
        .when().get("/animais")
        .then()
        .statusCode(200)
        
        .body("size()", is(2), "nome", hasItems("Bode", "Cachorro"), "id", hasItems(1, 2));
    }

    @Test
    @Order(2)
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
    @Order(3)
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