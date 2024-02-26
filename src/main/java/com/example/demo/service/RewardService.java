package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.demo.controller.RewardController;
import com.example.demo.model.CustomerPoint;
import com.example.demo.model.Transaction;

@Service
public class RewardService {
	
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RewardService.class);

	
	public List<CustomerPoint> calculateRewardPoints(List<Transaction> transactions) {
		
		Map<Long, CustomerPoint> customerPointsMap = new HashMap<>();

		try {
        for (Transaction transaction : transactions) {
            customerPointsMap.computeIfAbsent(transaction.getCustomerId(), k -> {
                CustomerPoint customerPoints = new CustomerPoint();
                customerPoints.setMonthlyPoints(new HashMap<>()); // Initialize monthlyPoints map
                return customerPoints;
            });

            CustomerPoint customerPoints = customerPointsMap.get(transaction.getCustomerId());

            String monthKey = transaction.getDate().getMonth().toString();

            int points = 0;
            if (transaction.getAmount() > 100) {
                points += (int) ((transaction.getAmount() - 100) * 2);
            }

            if (transaction.getAmount() > 50) {
                points += (int) ((Math.min(transaction.getAmount(), 100) - 50) * 1);
            }

            customerPoints.setTotalPoints(customerPoints.getTotalPoints() + points);
            customerPoints.getMonthlyPoints().merge(monthKey, points, Integer::sum);
            customerPoints.setCustomerId(transaction.getCustomerId());
        }
		} catch(Exception e) {
			log.info("Some exception occured", e.getMessage());
		}

        return new ArrayList<>(customerPointsMap.values());
    }

}
