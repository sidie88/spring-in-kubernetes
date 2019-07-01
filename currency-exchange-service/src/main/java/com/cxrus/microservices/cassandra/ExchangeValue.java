package com.cxrus.microservices.cassandra;

import java.math.BigDecimal;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("exchange_value")
public class ExchangeValue {

	@PrimaryKey 
	private ExchangeKey key;
	
	private BigDecimal conversionMultiple;
	private int port;
	private String ipAddress;
	
	public ExchangeValue() {}


	public ExchangeValue(final ExchangeKey key, final BigDecimal conversionMultiple, final int port, final String ipAddress) {
		this.key = key;
		this.conversionMultiple = conversionMultiple;
		this.port = port;
		this.ipAddress = ipAddress;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
}
