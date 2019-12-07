package com.github.viniciusfcf.elasticsearch;


// public class CustomElasticsearchAnalysisConfigurer implements ElasticsearchAnalysisConfigurer {

//     @Override
//     public void configure(ElasticsearchAnalysisConfigurationContext context) {
//         //https://www.elastic.co/guide/en/elasticsearch/reference/current/analysis-tokenizers.html
//         //https://www.elastic.co/guide/en/elasticsearch/reference/current/analysis-tokenfilters.html
        
//         context.analyzer("string_generica").custom().tokenizer("standard").tokenFilters("asciifolding", "lowercase");
//         context.normalizer("sort_string_generica").custom().tokenFilters("asciifolding", "lowercase");
        
//         //Acessando configurações dos índices criados:
//         //http://localhost:9200/<NOME_ENTIDADE>/

//         //Busca simples
//         //http://localhost:9200/<NOME_ENTIDADE>/_search
        
//     }
// }