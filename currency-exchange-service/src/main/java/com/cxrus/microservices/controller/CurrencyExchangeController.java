package com.cxrus.microservices.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cxrus.microservices.cassandra.ExchangeValue;
import com.cxrus.microservices.cassandra.ExchangeValueRepository;

@RestController
public class CurrencyExchangeController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValue exchangeValue = 
				repository.findOneByKeyFromAndKeyTo(from, to);
		logger.info("{}", exchangeValue);
		
		return exchangeValue;
	}
	
	@PostMapping("/currency-exchange/create")
	public ExchangeValue createExchangeValue(@RequestBody ExchangeValue exchange) {
		return repository.save(exchange);
	}
}
