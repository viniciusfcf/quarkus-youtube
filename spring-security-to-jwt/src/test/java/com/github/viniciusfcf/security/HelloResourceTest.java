package com.github.viniciusfcf.security;

import static org.hamcrest.CoreMatchers.is;
import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

@QuarkusTest
public class HelloResourceTest {

    private String token;

	@BeforeEach
    public void gereToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTClaims.json", null);
    }

    private RequestSpecification givenAutenticado() {
        return RestAssured.given()
                .contentType(ContentType.JSON).header(new Header("Authorization", "Bearer " + token));
    }

    @Test
    public void testHelloEndpoint() {
        givenAutenticado()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testPre1() {
        givenAutenticado()
          .when().get("/hello/pre1")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testPre2() {
        givenAutenticado()
          .when().get("/hello/pre2")
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testPre3() {
        //autenticado
        givenAutenticado()
          .when().get("/hello/pre3")
          .then()
             .statusCode(200)
             .body(is("hello"));

        //anonimo
        given()
             .when().get("/hello/pre3")
             .then()
                .statusCode(200)
                .body(is("hello"));
           
    }

    @Test
    public void testPre4() {
        //autenticado
        givenAutenticado()
          .when().get("/hello/pre4")
          .then()
             .statusCode(403);

        //anonimo, nao seria 403?
        given()
             .when().get("/hello/pre4")
             .then()
                .statusCode(401);
           
    }

    @Test
    public void testPre5() {
        given()
          .when().get("/hello/pre5")
          .then()
             .statusCode(200)
             .body(is("hello"));

        //so pode anonimo...
        givenAutenticado()
             .when().get("/hello/pre5")
             .then()
                .statusCode(403);
    }

    @Test
    public void testPre6() {
        //autenticado
        givenAutenticado()
          .when().get("/hello/pre6")
          .then()
             .statusCode(200)
             .body(is("hello"));

        //anonimo
        given()
             .when().get("/hello/pre6")
             .then()
                .statusCode(401);
           
    }

    @Test
    public void testPre7() {
        givenAutenticado()
          .with().pathParam("username", "jdoe@quarkus.io")
          .when().get("/hello/pre7/{username}")
          .then()
             .statusCode(200)
             .body(is("hello"));

        givenAutenticado()
             .with().pathParam("username", "nome errado")
             .when().get("/hello/pre7/{username}")
             .then()
                .statusCode(403);
    }

}