package com.github.viniciusfcf.camel;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.endpoint.EndpointRouteBuilder;

@ApplicationScoped
public class HelloCamelResource extends EndpointRouteBuilder {


	@Override
	public void configure() throws Exception {
        
        from(platformHttp("/camel/hello"))
        .setBody().simple("Respondendo do Quarkus + Camel")
        .to(slack("#teste-para-o-canal")
            .iconEmoji(":ghost:")
            .username("Bot do Quarkus")
            .webhookUrl("https://hooks.slack.com/services/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"))
        .to(slack("#geral")
            .webhookUrl("https://hooks.slack.com/services/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"))
        ;
	}
}