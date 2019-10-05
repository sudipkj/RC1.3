package com.cal.currencyconversionservice;

import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	ICurrencyExchangeServiceProxy icurrencyExchangeServiceProxy;
	
	Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrrency(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") int quantity) {
		LOGGER.info("---------------------------------- Start conversion service-------------------------");
		
		CurrencyConversionBean value = icurrencyExchangeServiceProxy.convertCurrrencyUsingOpenFeign(from, to);
		value.setTotalCalculatedAmount(BigDecimal.valueOf(quantity).multiply(value.getConversionValue()));
		
		
		LOGGER.info("---------------------------------- END conversion service-------------------------");
		return value;
	}
}
