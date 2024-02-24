package com.example.demo.model;

import java.util.Map;
import java.util.Objects;

public class CustomerPoint {

	 private Long customerId;
	 private int totalPoints;
	 private Map<String, Integer> monthlyPoints;
	 
	 public CustomerPoint() {
		 
	 }

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public int getTotalPoints() {
		return totalPoints;
	}

	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}

	public Map<String, Integer> getMonthlyPoints() {
		return monthlyPoints;
	}

	public void setMonthlyPoints(Map<String, Integer> monthlyPoints) {
		this.monthlyPoints = monthlyPoints;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, monthlyPoints, totalPoints);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerPoint other = (CustomerPoint) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(monthlyPoints, other.monthlyPoints)
				&& totalPoints == other.totalPoints;
	}

	@Override
	public String toString() {
		return "CustomerPoint [customerId=" + customerId + ", totalPoints=" + totalPoints + ", monthlyPoints="
				+ monthlyPoints + "]";
	}

	public CustomerPoint(Long customerId, int totalPoints, Map<String, Integer> monthlyPoints) {
		super();
		this.customerId = customerId;
		this.totalPoints = totalPoints;
		this.monthlyPoints = monthlyPoints;
	}
	 
	 
}
