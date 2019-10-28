package com.github.viniciusfcf.fault;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;


@Path("/fault")
public class FaultResource {

    @GET
    @Path("timeout")
    @Timeout(value=100)
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "methodnameFallback")
    public String methodname() throws InterruptedException {
        Thread.sleep(new Random().nextInt(500));
        return "hello timeout";
    }

    public String methodnameFallback() throws InterruptedException {
        return "hello fallback timeout";
    }

    @GET
    @Path("retry")
    @Retry(maxRetries = 1)
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(fallbackMethod = "methodnameFallback")
    public String retry() throws InterruptedException {
        if(new Random().nextBoolean()) {
            throw new NullPointerException();
        }
        return "hello retry";
    }


    @GET
    @Path("circuit")
    // @Retry(maxRetries = 1)
    @CircuitBreaker(requestVolumeThreshold = 5, failureRatio = 0.1, delay = 10000, 
    successThreshold = 10)
    @Produces(MediaType.TEXT_PLAIN)
    public String circuitBreaker() throws InterruptedException {
        if(new Random().nextInt(3) >= 2) {
            throw new NullPointerException();
        }
        return "hello circuit";
    }

    

    

    


}