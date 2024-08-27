package com.web.microservices.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.persistence.GeneratedValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class CircuitBreakerController {

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse" )
//    @CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse" )
    @RateLimiter(name = "default")
    @Bulkhead(name = "default")
    public String sampleAPI(){
        log.info("sample api");
//        return new RestTemplate().getForObject("http://localhost:8080/some", String.class);
        return "result";
    }

    public String hardCodedResponse(Exception e){
        return "hardCodedResponse";
    }
}
