package com.github.viniciusfcf.vertx;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.vertx.axle.sqlclient.Row;
import io.vertx.axle.sqlclient.RowSet;
import io.vertx.axle.sqlclient.Tuple;

@ApplicationScoped
public class FrutaService {

	@Inject
	io.vertx.axle.pgclient.PgPool client;

	@PostConstruct
	void config() {
		initdb();
	}

	private void initdb() {
		CompletionStage<RowSet<Row>> queries = client.query("DROP TABLE IF EXISTS fruta")
				.thenCompose(r -> client.query("CREATE TABLE fruta (id SERIAL PRIMARY KEY, nome TEXT NOT NULL)"))
				.thenCompose(r -> client.query("INSERT INTO fruta (nome) VALUES ('Laranja')"))
				.thenCompose(r -> client.query("INSERT INTO fruta (nome) VALUES ('Pera')"))
				.thenCompose(r -> client.query("INSERT INTO fruta (nome) VALUES ('Maçã')"));

		queries.toCompletableFuture().join();
	}
	
	public CompletionStage<List<Fruta>> buscarFrutas() {
		return client.preparedQuery("select id, nome from fruta order by id asc")
				.thenApply(RowSet::spliterator)
				.thenApply(spliterator -> StreamSupport.stream(spliterator, false).map(row -> from(row)).collect(Collectors.toList()));
	}
	
	public CompletionStage<Integer> atualizar(Long id, String nome) {
		return client.preparedQuery("update fruta set nome = $2 where id = $1", Tuple.of(id, nome))
				.thenApply(RowSet::rowCount);
	}

	public CompletionStage<Integer> inserir(String nome) {
		return client.preparedQuery("insert into fruta (nome) values ($1)", Tuple.of(nome))
				.thenApply(RowSet::rowCount);
	}
	
	public CompletionStage<Integer> deletar(Long id) {
		return client.preparedQuery("delete from fruta where id = $1", Tuple.of(id))
				.thenApply(RowSet::rowCount);
	}
	
	
	private Fruta from(Row row) {
		return new Fruta(row.getLong("id"), row.getString("nome"));
	}


	
}