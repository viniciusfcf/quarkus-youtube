package com.github.viniciusfcf.cache;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.cache.CacheInvalidate;
import io.quarkus.cache.CacheInvalidateAll;
import io.quarkus.cache.CacheKey;
import io.quarkus.cache.CacheResult;

@ApplicationScoped
public class MeuServicoDemorado {
    
    private AtomicInteger inteiro = new AtomicInteger();

    /*
        Anotações suportadas:
            @Cacheable
            @CachePut
            @CacheEvict

        NAO SUPORTADO AINDA:
        "key", "keyGenerator", "cacheManager", "cacheResolver", "condition", "unless", "sync", "beforeInvocation"
    */



    // @Cacheable(value = "nome-do-cache")
    @CacheResult(cacheName = "nome-do-cache")
    public String primeiroCacheavel(String id, Object entidade) {
        demore();
        return "Primeiro Método Cacheavel "+inteiro.getAndIncrement()+", ID: "+id;
    }
    
    // @CacheEvict(value = "nome-do-cache", allEntries = true)
    @CacheInvalidateAll(cacheName = "nome-do-cache")
    public void limpePrimeiroCacheTodo() {
    }

    // @CacheEvict(value = "nome-do-cache")
    @CacheInvalidate(cacheName = "nome-do-cache")
    public void limpePrimeiroCache(String id, Object entidade) {
    }


    // @CachePut(value = "nome-do-cache")
    //Não temos uma anotação similar
    public String segundoCacheavel(String id, Object entidade) {
        demore();
        return "Segundo Cacheavel "+inteiro.getAndIncrement()+", ID: "+id;
    }

	private void demore() {
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

       

}