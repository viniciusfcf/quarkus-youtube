package com.github.viniciusfcf.hello.junit;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeAnimalResourceTestIT extends AnimalResourceTest {

    // Executa os mesmo testes mas no modo nativo. Herança não é obrigatória
    
    // EM BREVE TESTES EM DOCKERS...

    //NAO SUPORTA INJECT
}