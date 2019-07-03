package com.cxrus.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cxrus.microservices.currencyconversionservice.model.CurrencyConversionBean;

@FeignClient(name="currency-exchange-service", url = "${currency-exchange-service.ribbon.listOfServers}")
public interface CurrencyExchangeServiceProxy {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue
		(@PathVariable("from") String from, @PathVariable("to") String to);
	
	@PostMapping("/currency-exchange/create")
	public CurrencyConversionBean createExchangeValue
		(@RequestBody CurrencyConversionBean exchangeValue);
	
}
