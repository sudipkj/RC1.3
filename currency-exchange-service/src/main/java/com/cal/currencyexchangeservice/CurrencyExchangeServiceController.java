package com.cal.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeServiceController {

	
	@Autowired
	Environment environment;
	
	@Autowired
	private IExchangeValueRepository iexchangeValueRepository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
		
		ExchangeValue exVal = iexchangeValueRepository.findByFromAndTo(from, to);
		exVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exVal;
	}
	
}
