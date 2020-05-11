package com.github.viniciusfcf.springweb;

import static io.restassured.RestAssured.given;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;

@QuarkusTest
@TestMethodOrder(value = OrderAnnotation.class)
public class ProdutoControllerTest {


    @BeforeAll
    public static void defaultParser() {
        RestAssured.defaultParser = Parser.JSON;
    }

    @Test
    @Order(1)
    public void testGetAll() {
        given()
                .when().get("/produtos")
                .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(2))
                .and()
                .body("id", CoreMatchers.hasItems(1, 2));
    }

    @Test
    @Order(2)
    public void testGetByName() {
        given()
                .when().queryParam("nome", "Nescau").get("/produtos")
                .then()
                .statusCode(200)
                .body("size()", CoreMatchers.is(1))
                .and()
                .body("nome", CoreMatchers.hasItems("Nescau"));
    }

    @Test
    @Order(3)
    public void addProdutoAndFindById() {
        Produto produto = new Produto();
        produto.setId(3L);
        produto.setNome("Camarão");
        given().body(produto)
                .contentType(ContentType.JSON)
                .when().post("/produtos")
                .then()
                .statusCode(204);
        given()
            .when().pathParam("id", 3).get("/produtos/{id}")
            .then()
            .statusCode(200)
            .body("id", CoreMatchers.is(3));
    }

    @Test
    @Order(4)
    public void testGetById() {
        given()
                .when().pathParam("id", 1).get("/produtos/{id}")
                .then()
                .statusCode(200)
                .body("id", CoreMatchers.is(1));
    }

    @Test
    @Order(5)
    public void putProdutoAndFindById() {
        Produto produto = new Produto();
        produto.setNome("Novo Nome");
        given().body(produto)
                .contentType(ContentType.JSON)
                .pathParam("id", 1)
                .when().put("/produtos/{id}")
                .then()
                .statusCode(204);
        given()
            .when().pathParam("id", 1).get("/produtos/{id}")
            .then()
            .statusCode(200)
            .body("nome", CoreMatchers.is("Novo Nome"));
    }

    @Test
    @Order(6)
    public void patchProdutoAndFindById() {
        Produto produto = new Produto();
        produto.setNome("Novo Nome");
        given().body(produto)
                .contentType(ContentType.JSON)
                .pathParam("id", 1)
                .when().patch("/produtos/{id}")
                .then()
                .statusCode(204);
        given()
            .when().pathParam("id", 1).get("/produtos/{id}")
            .then()
            .statusCode(200)
            .body("nome", CoreMatchers.is("Novo Nome"));
    }

    @Test
    @Order(7)
    public void deleteById() {
        given()
                .when().pathParam("id", 1).delete("/produtos/{id}")
                .then()
                .statusCode(204);
        
        given()
            .when().pathParam("id", 1).get("/produtos/{id}")
            .then()
            .statusCode(204);
    }

    @Test
    @Order(8)
    public void excecao() {
        given()
                .when().get("/produtos/excecao")
                .then()
                .statusCode(502);
        
    }
}
