package com.reward.application.model;

import java.util.Date;

import org.springframework.stereotype.Component;
/**
 * Represents an Purchase details.
 * Used to store purchase details.
 */
@Component
public class PurchaseDAO {
	private Long custId;
	private String customerName;
	private Long purchaseId;
	private String productName;
	private Double productAmount;
	private Date createdDt;
	
	public PurchaseDAO() {}
	
	public PurchaseDAO(Long custId, String customerName, Long purchaseId, String productName, Double productAmount, Date createdDt) {
		this.custId = custId;
		this.customerName = customerName;
		this.purchaseId = purchaseId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.createdDt = createdDt;
	}
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
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

	public Date getCreatedDt() {
		return createdDt;
	}
	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}
}
