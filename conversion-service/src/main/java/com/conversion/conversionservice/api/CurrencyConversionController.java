package com.conversion.conversionservice.api;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.conversion.conversionservice.models.CurrencyConversion;
import com.conversion.conversionservice.proxies.ExchangeApiProxy;

@RestController
public class CurrencyConversionController {
  private Logger logger = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private ExchangeApiProxy proxy;

  @GetMapping("/")
  public String testSystem() {
    return "It's Alive";
  }

  @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
  public CurrencyConversion convertCurrency(@PathVariable String from, @PathVariable String to,
      @PathVariable BigDecimal quantity) {

    Map<String, String> uriVariables = new HashMap<>();
    uriVariables.put("from", from);
    uriVariables.put("to", to);

    CurrencyConversion response = proxy.retrieveExchangeValue(from, to);
    logger.info("{}", response);

    return new CurrencyConversion(from, to, response.getConversionMultiple(), quantity,
        quantity.multiply(response.getConversionMultiple()), response.getPort());
  }
}
