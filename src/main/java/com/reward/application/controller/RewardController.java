package com.reward.application.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reward.application.entity.PurchaseDetailsEntity;
import com.reward.application.model.PurchaseRequest;
import com.reward.application.service.RewardService;

import jakarta.validation.Valid;
/**
 * Controller for handling Rewards-related requests.
 * Provides REST end points to manage customer and purchase data.
 */
@RestController
@RequestMapping("/api/v1/reward")
@Validated
public class RewardController {

	private RewardService service;

	@Autowired
	public RewardController(RewardService service) {
		this.service = service;
	}
	/**
     * Create the purchase entry into the purchase details table.
     * 
     * @RequestBody is the purchased product details against customer who already registered.
     */
	@PostMapping("/purchase")
	public ResponseEntity<?> purchase(@Valid @RequestBody PurchaseRequest request) {
			PurchaseDetailsEntity entity = service.purchase(request);
			return ResponseEntity.ok().body(entity);
	}
	/**
     * Retrieves a list of all products along with total and month wise rewards for customer.
     * @param customer Id is the ID of customer.
     * @return List of purchase details wrapped in ResponseEntity.
     */
	@GetMapping("/{customerId}")
	public ResponseEntity<?> getPurchaseDetailsById(@PathVariable Long customerId) throws SQLException {
		return ResponseEntity.ok().body(service.getPurchaseDetailsById(customerId));
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllPurchaseDetails() throws SQLException {
		return ResponseEntity.ok().body(service.getAllPurchaseDetails());
	}
}
