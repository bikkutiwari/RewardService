package com.example.demo.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.model.CustomerPoint;
import com.example.demo.model.Transaction;
import com.example.demo.service.RewardService;

@ExtendWith(MockitoExtension.class)
public class RewardServiceTest {
	
	    @InjectMocks
	    private RewardService rewardService;

	    @Test
	    void testCalculateRewardPoints() {
	        // Test data
	    	 Transaction transaction1 = new Transaction(1L, 120, LocalDate.of(2024, 2, 1));
	         Transaction transaction2 = new Transaction(1L, 80, LocalDate.of(2024, 2, 15));
	         Transaction transaction3 = new Transaction(2L, 60, LocalDate.of(2024, 2, 28));

	         List<Transaction> transactions = Arrays.asList(transaction1, transaction2, transaction3);

	         // Expected results
	         CustomerPoint expectedCustomerPoint1 = new CustomerPoint(1L, 120, Map.of("FEBRUARY", 120));
	         CustomerPoint expectedCustomerPoint2 = new CustomerPoint(2L, 10, Map.of("FEBRUARY", 10));

	         // Invoke the service method
	         List<CustomerPoint> result = rewardService.calculateRewardPoints(transactions);

	         // Verify the results
	         assertEquals(2, result.size());

	         // You may want to implement custom equals() method in CustomerPoint for a more detailed comparison
	         assertEquals(expectedCustomerPoint1, result.get(0));
	         assertEquals(expectedCustomerPoint2, result.get(1));
	    }
}
