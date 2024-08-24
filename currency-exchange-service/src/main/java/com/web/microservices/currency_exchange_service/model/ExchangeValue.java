package com.web.microservices.currency_exchange_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
public class ExchangeValue {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name="curr_from")
    private String from;
    @Column(name="curr_to")
    private String to;
    private BigDecimal conversionMultiple;
    private int port;

    public ExchangeValue(Long id, String from, String to, BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
        this.to = to;
        this.from = from;
        this.id = id;
    }
}
