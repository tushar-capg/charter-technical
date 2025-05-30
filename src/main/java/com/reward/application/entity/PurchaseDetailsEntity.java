package com.reward.application.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Represents an entity class.
 * Used to create Purchase_Details table.
 */
@Entity
@Table(name="PURCHASE_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDetailsEntity extends CommonFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PURCHASE_ID")
	private Long purchaseId;
	@Column(name = "CUSTOMER_ID")
	private Long custId;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_AMOUNT")
	private Double productAmount;
	
	public PurchaseDetailsEntity() {
	}
	
	public PurchaseDetailsEntity(Long custId, String productName, Double productAmount, Date createdDt) {
		this.custId = custId;
		this.productName = productName;
		this.productAmount = productAmount;
		this.createdDt = createdDt;
	}
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
