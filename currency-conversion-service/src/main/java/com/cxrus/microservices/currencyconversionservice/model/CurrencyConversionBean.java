package com.cxrus.microservices.currencyconversionservice.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class CurrencyConversionBean {

	private CurrencyConversionKeyBean key;
	
	private BigDecimal conversionMultiple;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal quantity;
	
	@JsonInclude(Include.NON_NULL)
	private BigDecimal totalCalculatedAmount;
	
	public CurrencyConversionKeyBean getKey() {
		return key;
	}
	public void setKey(CurrencyConversionKeyBean key) {
		this.key = key;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
	public CurrencyConversionBean(CurrencyConversionKeyBean key, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount) {
		this.key = key;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	
	public CurrencyConversionBean(CurrencyConversionKeyBean key, BigDecimal conversionMultiple) {
		this.key = key;
		this.conversionMultiple = conversionMultiple;
	}
	
	public CurrencyConversionBean() {}
	
	
}
