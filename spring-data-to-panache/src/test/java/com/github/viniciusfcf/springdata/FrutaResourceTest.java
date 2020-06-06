package com.github.viniciusfcf.springdata;

import static io.restassured.RestAssured.*;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import io.quarkus.test.junit.QuarkusTest;
 
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class FrutaResourceTest   {

    @Test
    public void testHelloEndpoint() {
        given()
            .when().get("/frutas")
            .then()
                .statusCode(200)
                .body("id", CoreMatchers.hasItems(11, 12, 13 ,14));
    }

    @Test
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
    public void testAdd() {
        
        given().pathParam("nome", "Caju").pathParam("cor", "Amarelo")
            .when().post("/frutas/nome/{nome}/cor/{cor}")
            .then()
                .statusCode(200)
                .body("nome", CoreMatchers.is("Caju"), 
                        "cor", CoreMatchers.is("Amarelo"));
    }

    @Test
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

}