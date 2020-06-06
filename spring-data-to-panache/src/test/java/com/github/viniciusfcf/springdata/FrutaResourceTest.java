package com.github.viniciusfcf.springdata;

import static io.restassured.RestAssured.given;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
 
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
@TestMethodOrder(OrderAnnotation.class)
public class FrutaResourceTest   {

    @Test
    @Order(1)
    public void testGelAll() {
        given()
            .when().get("/frutas")
            .then()
                .statusCode(200)
                .body("id", CoreMatchers.hasItems(11, 12, 13 ,14));
    }

    @Test
    @Order(2)
    public void testDelete() {
        
        given().pathParam("id", 11)
            .when().delete("/frutas/{id}")
            .then()
                .statusCode(204);

        given()
                .when().get("/frutas")
                .then()
                    .statusCode(200)
                    .body("id", CoreMatchers.not(CoreMatchers.hasItems(11)));
    }

    @Test
    @Order(3)
    public void testAdd() {
        
        given().pathParam("nome", "Caju").pathParam("cor", "Amarelo")
            .when().post("/frutas/nome/{nome}/cor/{cor}")
            .then()
                .statusCode(200)
                .body("nome", CoreMatchers.is("Caju"), 
                        "cor", CoreMatchers.is("Amarelo"));
    }

    @Test
    @Order(4)
    public void testPut() {
        
        given().pathParam("id", "12").pathParam("cor", "Azul")
            .when().put("/frutas/id/{id}/cor/{cor}")
            .then()
                .statusCode(200)
                .body("nome", CoreMatchers.is("Maçã"), 
                        "cor", CoreMatchers.is("Azul"),
                        "id", CoreMatchers.is(12)
                        );
    }

    @Test
    @Order(5)
    public void testGelAllByCor() {
        given().pathParam("cor", "Verde")
            .when().get("/frutas/cor/{cor}")
            .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(1),
                    "id", CoreMatchers.hasItems(14));
    }

    @Test
    @Order(6)
    public void testGelAllByCorOrdenado() {
        given().pathParam("cor", "Amarelo")
            .when().get("/frutas/cor/ordenado/{cor}")
            .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(2),
                    "[0].nome", CoreMatchers.is("Banana"),
                    "[1].nome", CoreMatchers.is("Caju")
                    );
    }

    @Test
    @Order(7)
    public void testGelAllByNome() {
        given().pathParam("nome", "Abacate")
            .when().get("/frutas/nome/{nome}")
            .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(1),
                    "[0].nome", CoreMatchers.is("Abacate"),
                    "[0].cor", CoreMatchers.is("Verde")
                    );
    }

    @Test
    @Order(8)
    public void testGelById() {
        given().pathParam("id", 14)
            .when().get("/frutas/{id}")
            .then()
                .statusCode(200)
                .body(
                    "nome", CoreMatchers.is("Abacate"),
                    "cor", CoreMatchers.is("Verde"),
                    "id", CoreMatchers.is(14)
                    
                    );
    }

    @Test
    @Order(9)
    public void testGelAllPaginado() {
        given().queryParam("page", "1").queryParam("size", 2)
            .when().get("/frutas/paginado")
            .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(2),
                    "[0].nome", CoreMatchers.is("Caju"),
                    "[1].nome", CoreMatchers.is("Maçã")
                    );
    }

    @Test
    @Order(10)
    public void testDeleteByNomeLike() {
        given().pathParam("nome", "a")
            .when().delete("/frutas/nome/{nome}")
            .then()
                .statusCode(200)
                //vai apagar tudo
                .body(CoreMatchers.is("4"));
    }

}