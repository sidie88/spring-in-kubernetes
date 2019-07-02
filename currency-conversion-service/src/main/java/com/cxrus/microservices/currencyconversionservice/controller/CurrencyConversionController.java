package com.cxrus.microservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cxrus.microservices.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.cxrus.microservices.currencyconversionservice.model.CurrencyConversionBean;
import com.cxrus.microservices.currencyconversionservice.model.CurrencyConversionKeyBean;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity ) {
		
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		
		CurrencyConversionKeyBean key = new CurrencyConversionKeyBean(response.getKey().getId(), response.getKey().getFrom(), response.getKey().getTo());
		return new CurrencyConversionBean(key, response.getConversionMultiple(), 
				quantity, quantity.multiply(response.getConversionMultiple()),  response.getPort(), response.getIpAddress());
	}
}
