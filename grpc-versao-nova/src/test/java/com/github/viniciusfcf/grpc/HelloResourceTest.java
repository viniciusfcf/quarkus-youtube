package com.github.viniciusfcf.grpc;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;

import com.github.viniciusfcf.proto.service.UsuarioResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class HelloResourceTest {

    //NAO consegue fazer um MOCK do UsuarioServiceGRPC pq ele é SINGLETON!!!
    @InjectMock
    UsuarioService usuarioServiceMock;

    //MAIS DETALHES? Ler https://quarkus.io/blog/mocking/
    //É possivel fazer MOCK apenas em um método específico
    //https://quarkus.io/blog/mocking/#using-injectmock

    @Test
    public void testHelloEndpoint() {
        UsuarioResponse usuarioResponse = UsuarioResponse.newBuilder()
        .setId(111)
        .setNome("Laura")
        .setIdade(4)
        .build();

        Mockito.when(usuarioServiceMock.adicionarUsuario(any())).thenReturn(usuarioResponse); 
        given()
          .when().get("/hello/grpc/block")
          .then()
             .statusCode(200)
             .body(is("Laura"));
    }

}