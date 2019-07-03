package com.cxrus.microservices.cassandra;

import java.math.BigDecimal;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("exchange_value")
public class ExchangeValue {

	@PrimaryKey 
	private ExchangeKey key;
	
	private BigDecimal conversionMultiple;

	public ExchangeValue(final ExchangeKey key, final BigDecimal conversionMultiple) {
		this.key = key;
		this.conversionMultiple = conversionMultiple;
	}

	public ExchangeKey getKey() {
		return key;
	}

	public void setKey(ExchangeKey key) {
		this.key = key;
	}


	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}

	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	
}
