package com.cxrus.microservices.bloomberg;

import java.util.Date;

public class CrossCurrencies {
	
	private String currency;
	private String sourceCurrency;
	private Date lastPriceTime;
	private Double last;
	
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getSourceCurrency() {
		return sourceCurrency;
	}
	public void setSourceCurrency(String sourceCurrency) {
		this.sourceCurrency = sourceCurrency;
	}
	public Date getLastPriceTime() {
		return lastPriceTime;
	}
	public void setLastPriceTime(Date lastPriceTime) {
		this.lastPriceTime = lastPriceTime;
	}
	public Double getLast() {
		return last;
	}
	public void setLast(Double last) {
		this.last = last;
	}
	
	public CrossCurrencies() {}
	
	public CrossCurrencies(String currency, String sourceCurrency, Date lastPriceTime, Double last) {
		this.currency = currency;
		this.sourceCurrency = sourceCurrency;
		this.lastPriceTime = lastPriceTime;
		this.last = last;
	}
	@Override
	public String toString() {
		return "[currency=" + currency + ", sourceCurrency=" + sourceCurrency + ", lastPriceTime="
				+ lastPriceTime + ", last=" + last + "]";
	}
	
	
}
