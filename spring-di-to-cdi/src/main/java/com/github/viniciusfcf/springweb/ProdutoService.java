package com.github.viniciusfcf.springweb;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.eclipse.microprofile.config.inject.ConfigProperty;

// @Component
//@Service
//@Repository
//@Scope Singleton, prototype, request, session
@Singleton
public class ProdutoService {
    
    private final PrefixProducer messageProducer;

    // @Autowired
    // @Qualifier("noopFunction")
    @Inject
    @Named("noopFunction")
    StringFunction noopStringFunction;

    // @Autowired
    // @Qualifier("upperCaseFunction")
    @Inject
    @Named("upperCaseFunction")
    StringFunction capitalizerStringFunction;

    // @Value("${produto.suffix}")
    @ConfigProperty(name="produto.suffix")
    String suffix;

    public ProdutoService(PrefixProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    public String novoNome(String nome) {
        final String initialValue = messageProducer.getPrefix() + nome + suffix;
        return noopStringFunction.andThen(capitalizerStringFunction).apply(initialValue);
    }

    
}