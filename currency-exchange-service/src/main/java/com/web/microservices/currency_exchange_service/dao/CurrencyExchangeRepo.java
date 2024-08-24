package com.web.microservices.currency_exchange_service.dao;

import com.web.microservices.currency_exchange_service.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepo extends JpaRepository<ExchangeValue, Long> {

    ExchangeValue findByFromAndTo(String from, String to);
}
