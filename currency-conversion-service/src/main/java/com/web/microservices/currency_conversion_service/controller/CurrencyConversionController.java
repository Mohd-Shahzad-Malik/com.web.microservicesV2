package com.web.microservices.currency_conversion_service.controller;

import com.web.microservices.currency_conversion_service.Repo.FeignConfig;
import com.web.microservices.currency_conversion_service.model.ConversionValue;
import com.web.microservices.currency_conversion_service.model.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@RestController
@RequestMapping("v1")
@RibbonClient(name = "currency-exchange-service")
public class CurrencyConversionController {
    
    @Autowired
    private FeignConfig feignConfig;


    @RequestMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionValue retrieveCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity){
//          ExchangeValue forObject = new RestTemplate().getForObject("http://localhost:8001/v1/currency-exchange/from/" + from + "/to/" + to, ExchangeValue.class);
        ExchangeValue forObject = feignConfig.retriveExchangeValue(from, to);

        return  new ConversionValue(forObject.getId(),forObject.getFrom(),forObject.getTo(), forObject.getConversionMultiple(), quantity,forObject.getConversionMultiple().multiply(quantity), forObject.getPort() );
    }
}
