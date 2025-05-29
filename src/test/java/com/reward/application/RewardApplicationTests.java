package com.reward.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.reward.application.model.RewardResponse;
import com.reward.application.service.RewardService;
/**
 * Represents an test class.
 * Used to test the scenarios.
 */
@SpringBootTest
class RewardApplicationTests {

	@Autowired
    private RewardService rewardService;

    @Test
    public void testRewardCalculation() throws SQLException {
    	/*
    	 * 15L the is custId which is created for testing
    	 */
        RewardResponse response = rewardService.getPurchaseDetailsById(15L);
        assertNotNull(response);
        assertTrue(response.getTotalRewards() >= 0);
    }
    
    @Test
    public void testNegativeScenario_InvalidCustomerId() throws SQLException {
    	/*
    	 * -1L is passing to check negative scenarios.
    	 */
        RewardResponse response = rewardService.getPurchaseDetailsById(-1L);
        assertEquals(0, response.getTotalRewards());
    }
}
