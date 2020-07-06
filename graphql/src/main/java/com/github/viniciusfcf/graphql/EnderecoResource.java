package com.github.viniciusfcf.graphql;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

@GraphQLApi
public class EnderecoResource {
    

    @Query
    @Name("buscarEnderecos")
    public List<Endereco> buscarPessoas() {
        Endereco endereco = new Endereco();
        endereco.setNumero(123);
        endereco.setRua("Rua sem nome");
		return Collections.singletonList(endereco);
    }


}