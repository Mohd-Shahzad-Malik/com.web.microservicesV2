//package com.web.microservices.api_gateway.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class ApiGatewayConfiguration {
//
//    @Bean
//    public RouteLocator gatewayLocator(RouteLocatorBuilder builder){
//        return builder.routes().
//         route(p -> p.path("/get")
//         .filters(f -> f.addRequestHeader("MuHeader", "MyURL"))
//         .uri("http://httpbin.org:80"))
//                .route(p -> p.path("/v2/currency-conversion/**")
//                        .uri("lb://currency-conversion-service"))
//                .route(p -> p.path("/v2/currency-exchange/**")
//                        .uri("lb://currency-exchange-service"))
//                .route(p ->p.path("/currency-exchange/new/**")  // if we want to redirect the url to other url
//                        .filters(f -> f.rewritePath("/currency-exchange/new/(?<segment>.*)",
//                                "/v2/currency-exchange/${segment}"))
//                        .uri("lb://currency-exchange-service"))
//        .build();
//    }
//}
