package com.github.viniciusfcf;

import javax.enterprise.context.ApplicationScoped;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import org.eclipse.microprofile.reactive.streams.operators.PublisherBuilder;

@ApplicationScoped
public class Processor {
    
    @Incoming("command-mode-channel")
    @Outgoing("inteiros-channel")
    public PublisherBuilder<String> process(PublisherBuilder<String> in) {
        return in.filter(s -> StringUtils.isNumeric(s));
    }

}