package com.github.viniciusfcf.springdata;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

//org.springframework.data.repository.CrudRepository
//org.springframework.data.repository.Repository
//org.springframework.data.repository.PagingAndSortingRepository
//org.springframework.data.jpa.repository.JpaRepository
@ApplicationScoped
// public interface FrutaRepository extends CrudRepository<Fruta, Long> {
public class FrutaRepository implements  PanacheRepository<Fruta> {
    
    //Spring Data conventions
    public List<Fruta> findByCor(String cor) {
        return list("cor", cor);
    }

    public List<Fruta> findByCorOrderByNome(String cor) {
        return list("cor", Sort.ascending("nome"), cor);
    }

    //Anotação

    // @Query("select f from Fruta f where f.nome = ?1")
    public List<Fruta> nome(String nome) {
        return list("select f from Fruta f where f.nome = ?1", nome);
    }
    
    // @Query("from Fruta where id = :id")
    public Fruta findByIdentificador(
        // @Param("id")
         Long id ) {
        return find("from Fruta where id = :id", Parameters.with("id", id)).firstResult();
    }

    //Acho que nao deveria ter esse group by, mas no h2 deu erro: 
    //QUERY: select count(*) as col_0_0_ from Fruta fruta0_ order by fruta0_.nome
    //ERRO: Column "FRUTA0_.NOME" must be in the GROUP BY list; SQL statement:
    // @Query("from Fruta f group by nome order by nome")
    public List<Fruta> orderByNome(
        // Pageable
        Page 
        pageable) {
        return find("from Fruta f group by nome order by nome").page(pageable).list();
    }
    
    // @Modifying
    // @Query("delete from Fruta where nome like concat('%', ?1, '%')")
    public Long deleteByNomeLike(String nome) {
        return delete("nome like concat('%', ?1, '%')", nome);
    }


}