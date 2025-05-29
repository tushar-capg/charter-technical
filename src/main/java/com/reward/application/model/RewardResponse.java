package com.reward.application.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * Represents an response which holds purchase details for customer.
 * Used to store purchase details and total rewards for each customer.
 */
@Component
public class RewardResponse {
	
	private Long custId;
	private String customerName;
	private List<MonthWiseReward> monthWiseRewards = new ArrayList<>();
	private Integer totalRewards;
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
	public List<MonthWiseReward> getMonthWiseRewards() {
		return monthWiseRewards;
	}
	public void setMonthWiseRewards(List<MonthWiseReward> monthWiseRewards) {
		this.monthWiseRewards = monthWiseRewards;
	}
	public Integer getTotalRewards() {
		return totalRewards;
	}
	public void setTotalRewards(Integer totalRewards) {
		this.totalRewards = totalRewards;
	}
}
