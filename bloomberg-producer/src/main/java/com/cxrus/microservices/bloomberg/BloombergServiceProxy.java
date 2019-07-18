package com.cxrus.microservices.bloomberg;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Response;

@FeignClient(name="market", url = "https://bloomberg-market-and-financial-news.p.rapidapi.com")
public interface BloombergServiceProxy {
	@GetMapping(value ="/market/get-cross-currencies?id={id}", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Response getCrossCurrencies(
			@RequestHeader("X-RapidAPI-Host") String apiHost,
			@RequestHeader("X-RapidAPI-Key") String apiKey,
			@PathVariable("id") String id );
}
