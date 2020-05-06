package com.github.viniciusfcf;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MeuServico {
    
    public void facaAlgo() {
        System.out.println("MeuServico.facaAlgo()");
    }
}