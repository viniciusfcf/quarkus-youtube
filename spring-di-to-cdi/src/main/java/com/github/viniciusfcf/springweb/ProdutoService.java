package com.github.viniciusfcf.springweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@Service
//@Repository
//@Scope Singleton, prototype, request, session
public class ProdutoService {
    
    private final PrefixProducer messageProducer;

    @Autowired
    @Qualifier("noopFunction")
    StringFunction noopStringFunction;

    @Autowired
    @Qualifier("upperCaseFunction")
    StringFunction capitalizerStringFunction;

    @Value("${produto.suffix}")
    String suffix;

    public ProdutoService(PrefixProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public String novoNome(String nome) {
        final String initialValue = messageProducer.getPrefix() + nome + suffix;
        return noopStringFunction.andThen(capitalizerStringFunction).apply(initialValue);
    }

    
}