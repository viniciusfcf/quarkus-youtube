package com.github.viniciusfcf.springdata;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//org.springframework.data.repository.Repository
//org.springframework.data.repository.PagingAndSortingRepository
//org.springframework.data.jpa.repository.JpaRepository
public interface FrutaRepository extends CrudRepository<Fruta, Long> {
    
    //Spring Data conventions
    public List<Fruta> findByCor(String cor);

    public List<Fruta> findByCorOrderByNome(String cor);

    //Anotação

    @Query("select f from Fruta f where f.nome = ?1")
    Iterator<Fruta> nome(String nome);
    
    @Query("from Fruta where id = :id")
    Fruta findByIdentificador(@Param("id") Long id );

    @Modifying
    @Query("delete from Fruta where nome like concat('%', ?1, '%')")
    Long deleteByNomeLike(String nome);

    @Query("from Fruta order order by nome")
    Slice<Fruta> orderByNome(Pageable pageable);

}