package com.github.viniciusfcf.springdata;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

@Entity
public class Fruta extends PanacheEntity {


    public String nome;

    public String cor;

	public static List<Fruta> findByCor(String cor) {
        return list("cor", cor);
    }

    public static List<Fruta> findByCorOrderByNome(String cor) {
        return list("cor", Sort.ascending("nome"), cor);
    }

    //Anotação

    // @Query("select f from Fruta f where f.nome = ?1")
    public static List<Fruta> nome(String nome) {
        return list("select f from Fruta f where f.nome = ?1", nome);
    }
    
    // @Query("from Fruta where id = :id")
    public static Fruta findByIdentificador(
        // @Param("id")
         Long id ) {
        return find("from Fruta where id = :id", Parameters.with("id", id)).firstResult();
    }

    //Acho que nao deveria ter esse group by, mas no h2 deu erro: 
    //QUERY: select count(*) as col_0_0_ from Fruta fruta0_ order by fruta0_.nome
    //ERRO: Column "FRUTA0_.NOME" must be in the GROUP BY list; SQL statement:
    // @Query("from Fruta f group by nome order by nome")
    public static List<Fruta> orderByNome(
        // Pageable
        Page 
        pageable) {
        return find("from Fruta f group by nome order by nome").page(pageable).list();
    }
    
    // @Modifying
    // @Query("delete from Fruta where nome like concat('%', ?1, '%')")
    public static Long deleteByNomeLike(String nome) {
        return delete("nome like concat('%', ?1, '%')", nome);
    }

}