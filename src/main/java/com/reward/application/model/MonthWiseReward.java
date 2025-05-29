package com.reward.application.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.reward.application.enumeration.MonthsEnum;
/**
 * Represents an Month wise purchase details of each customer.
 * Used to store purchase details and month wise total rewards for each month.
 */
@Component
public class MonthWiseReward {
	
	private MonthsEnum month;
	private List<PurchaseDetails> purchaseDetails = new ArrayList<>();
	private Integer totalMonthlyRewards = 0;
	/**
	 * All the methods used to retrieves and set the details to and from fields.
	 * These getter methods are returns data from respective fields.
	 * These setter methods sets the values to the fields.
	 */
	public MonthsEnum getMonth() {
		return month;
	}
	public void setMonth(MonthsEnum month) {
		this.month = month;
	}
	public List<PurchaseDetails> getPurchaseDetails() {
		return purchaseDetails;
	}
	public void setPurchaseDetails(List<PurchaseDetails> purchaseDetails) {
		this.purchaseDetails = purchaseDetails;
	}
	public Integer getTotalMonthlyRewards() {
		return totalMonthlyRewards;
	}
	public void setTotalMonthlyRewards(Integer totalMonthlyRewards) {
		this.totalMonthlyRewards = totalMonthlyRewards;
	}
}
