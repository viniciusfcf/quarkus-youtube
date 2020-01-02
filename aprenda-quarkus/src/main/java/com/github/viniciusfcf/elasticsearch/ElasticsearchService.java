package com.github.viniciusfcf.elasticsearch;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@ApplicationScoped
public class ElasticsearchService {

    @Inject
    EntityManager entityManager;


	// public void rebuildIndexes() throws InterruptedException {
    //     //startAndWait para testes
    //     Search.session(entityManager)
    //                 .massIndexer()
    //                 .startAndWait();
    // }
    
    // public <T> List<T> search(Class<T> clazz, String termo, Optional<Integer> tamanho, String... fields) {
    //     return Search.session(entityManager).search(clazz)
	// 			.predicate(f -> StringUtils.isEmpty(termo)? f.matchAll()
	// 					: f.simpleQueryString().fields(fields).matching(termo))
	// 			.fetchHits(tamanho.orElse(20));
    // }

    
}