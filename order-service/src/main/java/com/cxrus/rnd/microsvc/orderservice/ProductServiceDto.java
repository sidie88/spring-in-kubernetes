package com.cxrus.rnd.microsvc.orderservice;

import java.math.BigDecimal;

public class ProductServiceDto {
	private Long id;
	private String name;
	private String description;
	private int stock;
	private BigDecimal price;
	
	public ProductServiceDto() {
	}
	
	public ProductServiceDto(Long id, String name, String description, int stock, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductServiceDto [id=" + id + ", name=" + name + ", description=" + description + ", stock=" + stock
				+ ", price=" + price + "]";
	}
}
