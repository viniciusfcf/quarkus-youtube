package com.github.viniciusfcf.panache;
import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaRepositorio implements PanacheRepository<Pessoa> {

}