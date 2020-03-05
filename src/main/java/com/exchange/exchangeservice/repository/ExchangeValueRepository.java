package com.exchange.exchangeservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.exchange.exchangeservice.models.ExchangeValue;


public interface ExchangeValueRepository extends CrudRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
