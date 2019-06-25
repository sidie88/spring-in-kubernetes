package com.cxrus.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cxrus.microservices.currencyexchangeservice.model.ExchangeValue;

public interface ExchangeValueRepository extends 
		JpaRepository<ExchangeValue, Long> {
	
	ExchangeValue findByFromAndTo(String from, String to);

}
