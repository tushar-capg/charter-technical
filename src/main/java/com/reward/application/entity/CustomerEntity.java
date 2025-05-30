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
 * Used to create Customer_Details table.
 */
@Entity
@Table(name="CUSTOMER_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity extends CommonFields {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID")
	private Long custId;
	@Column(name = "CUSTOMER_NAME")
	private String customerName;
	@Column(name = "ADDRESS")
	private String address;
	@Column(name = "MOBILE_NUMBER", unique = true, nullable = false)
	private Long mobileNumber;
	
	public CustomerEntity() {
		
	}
	
	public CustomerEntity(String customerName, String address, Long mobileNumber, Date createdDt) {
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}
