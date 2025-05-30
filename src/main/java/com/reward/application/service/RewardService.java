package com.reward.application.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reward.application.entity.CustomerEntity;
import com.reward.application.entity.PurchaseDetailsEntity;
import com.reward.application.enumeration.MonthsEnum;
import com.reward.application.model.MonthWiseReward;
import com.reward.application.model.PurchaseDAO;
import com.reward.application.model.PurchaseDetails;
import com.reward.application.model.PurchaseRequest;
import com.reward.application.model.RewardResponse;
import com.reward.application.repository.CustomerRepository;
import com.reward.application.repository.PurchaseRepository;

import jakarta.validation.ValidationException;
/**
 * Service layer for managing all rewards related operations.
 * Acts as an intermediary between the controller and repository.
 */
@Service
public class RewardService {

	private CustomerRepository customerRepository;
	private PurchaseRepository purchaseRepository;

	@Autowired
	public RewardService(CustomerRepository customerRepository, PurchaseRepository purchaseRepository) {
		this.customerRepository = customerRepository;
		this.purchaseRepository = purchaseRepository;
	}
	
	/**
     * Retrieves all employees from the database.
     * 
     * @return List of Employee objects.
     */
	public PurchaseDetailsEntity purchase(PurchaseRequest request) {
		PurchaseDetailsEntity entity = new PurchaseDetailsEntity();
		try {
			Optional<CustomerEntity> customerEntity = customerRepository.findById(request.getCustId());
			if (customerEntity.isPresent()) {
				entity.setCustId(request.getCustId());
				entity.setProductName(request.getProductName());
				entity.setProductAmount(request.getProductAmount());
				entity.setCreatedDt(java.sql.Date.valueOf(LocalDate.now()));
				return purchaseRepository.saveAndFlush(entity);
			} else {
				throw new ValidationException("Customer is not present for Customer ID :" + request.getCustId());
			}
		} catch (ValidationException e) {
			//Logging the exception
			System.out.println("Customer data not present for customer id :"+request.getCustId());
			throw new ValidationException("Customer is not present for Customer ID :" + request.getCustId()+" ,Please register the customer");
		} catch (Exception e) {
			// Logging the exception
			System.out.println("Internal Server Error!");
		}
		return entity;
	}
	
	/**
     * Retrieves a list of purchase details by their customer ID.
     * 
     * @param id The customer ID to look up.
     * @return The RewardResponse object corresponding to the given customer ID.
     * @throws IllegalArgumentException if the data is not found.
     * @throws Exception if any unexpected exception occurs and handled in global exception
     */
	public RewardResponse getPurchaseDetailsById(Long customerId) throws SQLException {
		Optional<List<PurchaseDAO>> objList = purchaseRepository.findAllRewardDetailsByCustId(customerId);
		if (objList.isPresent() && !objList.get().isEmpty()) {
			try {
				RewardResponse response = new RewardResponse();
				return objList.get().stream().collect(Collectors.groupingBy(x -> x.getCustId())).entrySet().stream()
						.map(entry -> {
							response.setCustId(entry.getValue().get(0).getCustId());
							response.setCustomerName(entry.getValue().get(0).getCustomerName());
							return entry.getValue();
						}).map(x -> x.stream().map(i -> {
							List<MonthWiseReward> monthWiseRewardsList = response.getMonthWiseRewards();
							MonthWiseReward monthWiseRewards = new MonthWiseReward();
							monthWiseRewards.setMonth(MonthsEnum.getMonth(i.getCreatedDt().getMonth() + 1));

							List<PurchaseDetails> purchaseDetailsList = monthWiseRewards.getPurchaseDetails();
							PurchaseDetails purchaseDetails = new PurchaseDetails();
							purchaseDetails.setPurchaseId(i.getPurchaseId());
							purchaseDetails.setProductName(i.getProductName());
							purchaseDetails.setProductAmount(i.getProductAmount());
							purchaseDetails.setReward(this.calculateRewardPoints(i.getProductAmount()));
							purchaseDetailsList.add(purchaseDetails);

							monthWiseRewards.setPurchaseDetails(purchaseDetailsList);
							monthWiseRewards.setTotalMonthlyRewards(monthWiseRewards.getPurchaseDetails().stream()
									.mapToInt(PurchaseDetails::getReward).sum());
							monthWiseRewardsList.add(monthWiseRewards);

							response.setMonthWiseRewards(monthWiseRewardsList);
							response.setTotalRewards(response.getMonthWiseRewards().stream()
									.mapToInt(MonthWiseReward::getTotalMonthlyRewards).sum());
							return response;
						}).collect(Collectors.toList())).collect(Collectors.toList()).stream().flatMap(List::stream)
						.collect(Collectors.toList()).stream().filter(x -> x.getCustId().equals(customerId)).findFirst()
						.orElse(null);
			} catch (Exception e) {
				// log exception
				System.out.println("Internal Server Error!");
			}
		} else {
			throw new IllegalArgumentException(
					"Invalid customer ID provided, no matching record found for customer ID: " + customerId);
		}
		return new RewardResponse();
	}
	
	/**
     * Returns and reward value.
     * 
     * Parameter amount is the product amount by using rewards has been calculated.
     * (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 
     */
	public Integer calculateRewardPoints(Double amount) {
		int points = 0;
		if (amount > 100) {
			points += (int) (2 * (amount - 100));
			amount = 100.00;
		}
		if (amount > 50) {
			points += (int) (amount - 50);
		}
		return points;
	}

	public List<RewardResponse> getAllPurchaseDetails() {
		Optional<List<PurchaseDAO>> objList = purchaseRepository.findAllRewardDetails();
		List<RewardResponse> rewardResList = new ArrayList<>();
		if (objList.isPresent() && !objList.get().isEmpty()) {
			try {
				Map<Long, List<PurchaseDAO>> map = objList.get().stream().collect(Collectors.groupingBy(x -> x.getCustId()));
				System.out.println(map);
				for(Map.Entry<Long, List<PurchaseDAO>> entry : map.entrySet()) {
					RewardResponse response = new RewardResponse();
					response.setCustId(entry.getValue().get(0).getCustId());
					response.setCustomerName(entry.getValue().get(0).getCustomerName());
					for(PurchaseDAO i : entry.getValue()) {
						List<MonthWiseReward> monthWiseRewardsList = response.getMonthWiseRewards();
						MonthWiseReward monthWiseRewards = new MonthWiseReward();
						monthWiseRewards.setMonth(MonthsEnum.getMonth(i.getCreatedDt().getMonth() + 1));

						List<PurchaseDetails> purchaseDetailsList = monthWiseRewards.getPurchaseDetails();
						PurchaseDetails purchaseDetails = new PurchaseDetails();
						purchaseDetails.setPurchaseId(i.getPurchaseId());
						purchaseDetails.setProductName(i.getProductName());
						purchaseDetails.setProductAmount(i.getProductAmount());
						purchaseDetails.setReward(this.calculateRewardPoints(i.getProductAmount()));
						purchaseDetailsList.add(purchaseDetails);

						monthWiseRewards.setPurchaseDetails(purchaseDetailsList);
						monthWiseRewards.setTotalMonthlyRewards(monthWiseRewards.getPurchaseDetails().stream()
								.mapToInt(PurchaseDetails::getReward).sum());
						monthWiseRewardsList.add(monthWiseRewards);

						response.setMonthWiseRewards(monthWiseRewardsList);
					}
					response.setTotalRewards(response.getMonthWiseRewards().stream()
							.mapToInt(MonthWiseReward::getTotalMonthlyRewards).sum());
					rewardResList.add(response);
				}
			} catch (Exception e) {
				// log exception
				System.out.println("Internal Server Error!");
			}
		} else {
			throw new IllegalArgumentException(
					"No records found!");
		}
		return rewardResList;
	}
}
