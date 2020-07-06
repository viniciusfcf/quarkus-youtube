package com.github.viniciusfcf.graphql;

import java.util.Collections;
import java.util.List;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class PessoaResource {
    

    @Query
    @Name("buscarPessoas")
    public List<Pessoa> buscarPessoas() {
        Pessoa pessoa = new Pessoa();
        pessoa.setIdade(20);
        pessoa.setNome("Maria");
        return Collections.singletonList(pessoa);
    }

    @Name("endereco")
    public Endereco buscarEndereco(@Source Pessoa pessoa) {
        Endereco endereco = new Endereco();
        endereco.setNumero(123);
        endereco.setRua("Rua sem nome");
        return endereco; 
    }

    @Mutation
    public Pessoa adicionarPessoa(Pessoa pessoa) {
        System.out.println("PessoaResource.adicionarPessoa() "+pessoa.getNome());
        return pessoa;
    }

}