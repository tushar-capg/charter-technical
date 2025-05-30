package com.reward.application.model;

import org.springframework.stereotype.Component;

/**
 * Represents an product wise purchase details of each customer.
 * Used to store purchase details and product wise rewards for each product.
 */
@Component
public class PurchaseDetails {

	private Long purchaseId;
	private String productName;
	private Double productAmount;
	private Integer reward = 0;
	/**
	 * All the methods used to retrieves and set the details to and from fields.
	 * These getter methods are returns data from respective fields.
	 * These setter methods sets the values to the fields.
	 */
	public Long getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(Long purchaseId) {
		this.purchaseId = purchaseId;
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
	public Integer getReward() {
		return reward;
	}
	public void setReward(Integer reward) {
		this.reward = reward;
	}
}
