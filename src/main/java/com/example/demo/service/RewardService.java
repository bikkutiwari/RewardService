package com.example.demo.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.CustomerPoint;
import com.example.demo.model.Transaction;

@Service
public class RewardService {
	
	public CustomerPoint calculateRewardPoints(List<Transaction> transactions) {
        CustomerPoint customerPoints = new CustomerPoint();
        customerPoints.setMonthlyPoints(new HashMap<>());

        for (Transaction transaction : transactions) {
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
        }

        return customerPoints;
    }

}
