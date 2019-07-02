package com.cxrus.microservices.currencyconversionservice.model;

import java.util.UUID;

public class CurrencyConversionKeyBean {
	private UUID id;
	private String from;
	private String to;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public CurrencyConversionKeyBean(UUID id, String from, String to) {
		this.id = id;
		this.from = from;
		this.to = to;
	}
}
