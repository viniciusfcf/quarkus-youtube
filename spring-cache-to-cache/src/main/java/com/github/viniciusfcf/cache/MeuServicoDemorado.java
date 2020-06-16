package com.github.viniciusfcf.cache;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

@ApplicationScoped
public class MeuServicoDemorado {
    
    private AtomicInteger inteiro = new AtomicInteger();

/*
    NAO SUPORTADO AINDA:
    "key", "keyGenerator", "cacheManager", "cacheResolver", "condition", "unless", "sync", "beforeInvocation"
*/

    @Cacheable(value = "nome-do-cache")
    public String primeiroCacheavel(String id, Object entidade) {
        demore();
        return "Primeiro Método Cacheavel "+inteiro.getAndIncrement()+", ID: "+id;
    }
    
    @CacheEvict(value = "nome-do-cache", allEntries = true)
    public void limpePrimeiroCacheTodo() {
    }

    @CacheEvict(value = "nome-do-cache")
    public void limpePrimeiroCache(String id, Object entidade) {
    }


    @CachePut(value = "nome-do-cache")
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