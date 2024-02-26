package com.example.demo.controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerPoint;
import com.example.demo.model.Transaction;
import com.example.demo.service.RewardService;

@RestController
@RequestMapping("/api/rewards")
public class RewardController {
	
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(RewardController.class);


    @Autowired
    private RewardService rewardService;

    @PostMapping("/calculate")
    public ResponseEntity<List<CustomerPoint>> calculateRewardPoints(@RequestBody List<Transaction> transactions) {
        List<CustomerPoint> customerPoints = rewardService.calculateRewardPoints(transactions);
        return ResponseEntity.ok(customerPoints);
    }
}