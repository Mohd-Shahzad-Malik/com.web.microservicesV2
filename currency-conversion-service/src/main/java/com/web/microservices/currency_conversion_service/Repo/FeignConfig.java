package com.web.microservices.currency_conversion_service.Repo;

import com.web.microservices.currency_conversion_service.model.ExchangeValue;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//if we are using @RibbonCilent then no need to pass url in feignClient
@FeignClient(name = "currency-exchange-service") // check in naming server for the instances to call
public interface FeignConfig {

    @GetMapping("/v2/currency-exchange/from/{from}/to/{to}")
    ExchangeValue retriveExchangeValue(@PathVariable("from") String from , @PathVariable("to") String to);
}
