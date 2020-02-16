package com.github.viniciusfcf.kafka;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

@ApplicationScoped
public class PrecoOutgoing {

	private Random random = new Random();

	@Outgoing("preco-gerado")
	public Flowable<Double> generate() {
		return Flowable.interval(5, TimeUnit.SECONDS).map(tick -> random.nextDouble());
	}
	
	@Outgoing("preco-gerado-to-cluster")
	public Flowable<Double> generateToCluster() {
		return Flowable.interval(5, TimeUnit.SECONDS).map(tick -> random.nextDouble());
	}

}