package com.reward.application.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotNull;
/**
 * Represents an request for creating purchase into purchase details table.
 * Used to store purchase request details.
 */
@Component
public class PurchaseRequest {
	
	@NotNull(message = "Customer ID cannot be null")
	private Long custId;
	@NotNull(message = "Product name cannot be null")
	private String productName;
	@NotNull(message = "Product amount cannot be null")
	private Double productAmount;
	/**
	 * All the methods used to retrieves and set the details to and from fields.
	 * These getter methods are returns data from respective fields.
	 * These setter methods sets the values to the fields.
	 */
	public Long getCustId() {
		return custId;
	}
	public void setCustId(Long custId) {
		this.custId = custId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getProductAmount() {
		return productAmount;
	}
	public void setProductAmount(Double productAmount) {
		this.productAmount = productAmount;
	}
}
