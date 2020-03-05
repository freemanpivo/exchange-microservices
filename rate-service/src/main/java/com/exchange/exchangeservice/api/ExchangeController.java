package com.exchange.exchangeservice.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.exchange.exchangeservice.models.ExchangeValue;
import com.exchange.exchangeservice.repository.ExchangeValueRepository;

@RestController
public class ExchangeController {
	@Autowired
	private Environment environment;

	@Autowired
	private ExchangeValueRepository repository;

	// TODO: Extract this method to a controller. At api layer we must handle the responses.
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		ExchangeValue exchangeValue = repository.findByFromAndTo(fromCurrency, toCurrency);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

		return exchangeValue;
	}

	@GetMapping("/")
	public String showExchangeSupport() {
		return "Converte BRL para [EUR,USD,GBP] ou [EUR,USD,GBP] para BRL";
	}
}
