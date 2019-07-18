package com.cxrus.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cxrus.microservices.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.cxrus.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.cxrus.microservices.currencyconversionservice.model.CurrencyConversionKeyBean;

@RestController
public class CurrencyConversionController {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity ) {
		
//		return proxy.retrieveExchangeValue(from, to);
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		
		log.info("{}", response);
		
		return response;
	}
	
	@PostMapping("/currency-converter-feign/create")
	public CurrencyConversionBean createExchangeFeign
		(@RequestBody CurrencyConversionBean exchangeValue) {
		
		CurrencyConversionBean response = proxy.createExchangeValue(exchangeValue);
		CurrencyConversionKeyBean key = new CurrencyConversionKeyBean(response.getKey().getId(), 
				response.getKey().getFrom(), response.getKey().getTo());
		CurrencyConversionBean result = new CurrencyConversionBean(key, response.getConversionMultiple());
		return result;
	}
}
