package com.github.viniciusfcf.crud;

import io.quarkus.hibernate.orm.rest.data.panache.PanacheEntityResource;
import io.quarkus.rest.data.panache.ResourceProperties;

@ResourceProperties(hal = true)
public interface PessoaResource extends PanacheEntityResource<Pessoa, Long>{
    

}
