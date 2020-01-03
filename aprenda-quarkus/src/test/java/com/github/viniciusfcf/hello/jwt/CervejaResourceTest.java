package com.github.viniciusfcf.hello.jwt;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import com.github.viniciusfcf.hello.util.TokenUtils;

@QuarkusTest
public class CervejaResourceTest {

    private String token;

    @BeforeEach
    public void gerarToken() throws Exception {
        token = TokenUtils.generateTokenString("/JWTFuncionarioClaims.json", null);
    }

    @Test
    public void testmethodname() {
        given()
        .header("Authorization", "Bearer "+token)
        .when().get("/cervejas")
        .then()
            .statusCode(200)
            .body(is("Heineken"));
    }

}