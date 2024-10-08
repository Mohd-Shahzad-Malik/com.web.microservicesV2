package com.web.microservices.currency_exchange_service.controller;

import com.web.microservices.currency_exchange_service.dao.CurrencyExchangeRepo;
import com.web.microservices.currency_exchange_service.model.ExchangeValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@RequestMapping("/v2")
@Slf4j
public class CurrencyExchangeController {

    @Autowired
    Environment env;

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from , @PathVariable String to){
        log.info("inside [retrieveExchangeValue] from {}, to {}", from, to);
        ExchangeValue byFromAndTo = currencyExchangeRepo.findByFromAndTo(from, to);
        byFromAndTo.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port"))));
        return byFromAndTo;
    }

}
