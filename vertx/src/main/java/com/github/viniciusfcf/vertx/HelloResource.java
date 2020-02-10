package com.github.viniciusfcf.vertx;

import java.util.concurrent.CompletionStage;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.quarkus.runtime.StartupEvent;
import io.vertx.axle.core.eventbus.Message;
import io.vertx.ext.bridge.BridgeEventType;
import io.vertx.ext.web.handler.ErrorHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeOptions;

@Path("/hello")
public class HelloResource {

	/**
	 * Utiliza callbacks Para uso avançado ou se tem um código vertx que quer
	 * reutilizar no Quarkus
	 */
	@Inject
	io.vertx.core.Vertx vertxCore;
	@Inject
	io.vertx.core.eventbus.EventBus eventBusCore;

	/**
	 * RX Java Utilizado mais para transformação de streams
	 * 
	 */
	@Inject
	io.vertx.reactivex.core.Vertx vertxRX;
	@Inject
	io.vertx.reactivex.core.eventbus.EventBus eventBusRX;

	/**
	 * 
	 * Funciona muito bem com Quarkus e Microprofile (Utiliza CompletionStage and
	 * Reactive Streams)
	 * 
	 * 
	 */
	@Inject
	io.vertx.axle.core.Vertx vertxAxle;
	@Inject
	io.vertx.axle.core.eventbus.EventBus eventBusAxle;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}

	public void onStart2(@Observes io.vertx.ext.web.Router router) {
		router.get("/my-route").handler(rc -> rc.response().end("Hello from my route"));
	}

	public void onStart3(@Observes io.vertx.ext.web.Router router) {

		router.route("/eventbus/*").handler(eventBusHandler());
		router.route().failureHandler(errorHandler());
		router.route().handler(staticHandler());

	}

	private io.vertx.ext.web.handler.sockjs.SockJSHandler eventBusHandler() {
		io.vertx.ext.bridge.PermittedOptions permitted = new io.vertx.ext.bridge.PermittedOptions()
				.setAddress("olaPublish");
		BridgeOptions options = new BridgeOptions().addOutboundPermitted(permitted).addInboundPermitted(permitted);
		io.vertx.ext.web.handler.sockjs.SockJSHandler create = io.vertx.ext.web.handler.sockjs.SockJSHandler
				.create(vertxCore);
		create.bridge(options, event -> {
			if (event.type() == BridgeEventType.SOCKET_CREATED) {
				System.out.println("A socket was created");
			}
			event.complete(true);
		});
		return create;
	}

	private ErrorHandler errorHandler() {
		return ErrorHandler.create(true);
	}

	private StaticHandler staticHandler() {
		return StaticHandler.create().setCachingEnabled(false);
	}

	public void onStart(@Observes StartupEvent event) {

//
//        BridgeOptions options = new BridgeOptions().addOutboundPermitted(new PermittedOptions().setAddress("news-feed"));
//        SockJSHandler sockJSHandler = SockJSHandler.create(vertxRX);
//        sockJSHandler.bridge(options);
//        Router router = Router.router(vertxRX);
//        Route handler = router.route("/eventbus/*").handler(sockJSHandler);
//
//
//        // Serve the static resources
//        router.route().handler(StaticHandler.create());
//
//        vertxAxle.createHttpServer().listen(8080);
//    	vertxAxle.setPeriodic(1000, t -> {vertxAxle.eventBus().publish("news-feed", "news from the server!");
//    	System.out.println("A");});

	}

	@GET
	@Path("/async/{name}")
	public CompletionStage<String> hello(@PathParam("name") String name) {
		// Allow outbound traffic to the news-feed address

//		eventBusCore.send("ola", name);
//		eventBusCore.request("ola", name, r -> r.result());
//		eventBusCore.publish("ola", name);
//
//		eventBusRX.send("ola", name);
//		eventBusRX.request("ola", name, r -> r.result());
//		eventBusRX.publish("ola", name);

		eventBusAxle.publish("olaPublish", name);
		return eventBusAxle.<String>request("olaRequest", name).thenApply(Message::body);

//        return eventBusAxle.<String>send("olaRequest", name)             
//                .thenApply(Message::body);                                  
	}

	protected void exemploLeituraArquivo() {
		// Bare Vert.x:
		vertxCore.fileSystem().readFile("lorem-ipsum.txt", ar -> {
			if (ar.succeeded()) {
				System.out.println("Content:" + ar.result().toString("UTF-8"));
			} else {
				System.out.println("Cannot read the file: " + ar.cause().getMessage());
			}
		});

		// Rx Java 2 Vert.x
		vertxRX.fileSystem().rxReadFile("lorem-ipsum.txt").map(buffer -> buffer.toString("UTF-8")).subscribe(
				content -> System.out.println("Content: " + content),
				err -> System.out.println("Cannot read the file: " + err.getMessage()));

		// Axle API:
		vertxAxle.fileSystem().readFile("lorem-ipsum.txt").thenApply(buffer -> buffer.toString("UTF-8"))
				.whenComplete((content, err) -> {
					if (err != null) {
						System.out.println("Cannot read the file: " + err.getMessage());
					} else {
						System.out.println("Content: " + content);
					}
				});
	}
}