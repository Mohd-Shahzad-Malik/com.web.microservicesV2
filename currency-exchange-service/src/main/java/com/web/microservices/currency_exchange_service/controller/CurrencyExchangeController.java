package com.web.microservices.currency_exchange_service.controller;

import com.web.microservices.currency_exchange_service.dao.CurrencyExchangeRepo;
import com.web.microservices.currency_exchange_service.model.ExchangeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Objects;

@RestController
@RequestMapping("/v1")
public class CurrencyExchangeController {

    @Autowired
    Environment env;

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retriveExchangeValue(@PathVariable String from , @PathVariable String to){
        ExchangeValue byFromAndTo = currencyExchangeRepo.findByFromAndTo(from, to);
//        ExchangeValue exchangeValue = new ExchangeValue(byFromAndTo., from, to, BigDecimal.valueOf(65));
        byFromAndTo.setPort(Integer.parseInt(Objects.requireNonNull(env.getProperty("local.server.port"))));
        return byFromAndTo;
    }
}
