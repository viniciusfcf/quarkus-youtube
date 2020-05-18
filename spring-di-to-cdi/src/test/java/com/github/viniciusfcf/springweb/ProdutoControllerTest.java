package com.github.viniciusfcf.springweb;

import static io.restassured.RestAssured.given;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ProdutoControllerTest {


    @Test
    public void testGetByName() {
        given()
                .when().queryParam("nome", "Escova").get("/produtos/novo-nome")
                .then()
                .statusCode(200)
                .body(CoreMatchers.is("PRODUTO:ESCOVA-NOVO!!"));
    }
}
