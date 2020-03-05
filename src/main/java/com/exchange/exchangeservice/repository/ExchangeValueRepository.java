package com.exchange.exchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exchange.exchangeservice.models.ExchangeValue;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}