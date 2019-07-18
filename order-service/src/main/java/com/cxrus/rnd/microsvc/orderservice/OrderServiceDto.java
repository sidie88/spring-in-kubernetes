package com.cxrus.rnd.microsvc.orderservice;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "orders")
public class OrderServiceDto {
	@Id
	private Long id;
	private String orderCode;
	private String notes;
	private int quantity;
	private Long productId;
	
	@Transient
	private BigDecimal totalPrice;
	
	public OrderServiceDto() {
	}

	public OrderServiceDto(Long id, String orderCode, String notes, int quantity, Long productId, BigDecimal totalPrice) {
		super();
		this.id = id;
		this.orderCode = orderCode;
		this.notes = notes;
		this.quantity = quantity;
		this.productId = productId;
		this.totalPrice = totalPrice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "OrderServiceDto [id=" + id + ", orderCode=" + orderCode + ", notes=" + notes + ", quantity=" + quantity
				+ ", productId=" + productId + ", totalPrice=" + totalPrice + "]";
	}
	
}
