package com.example.demo.model;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {

	 private Long customerId;
	 private double amount;
	 private LocalDate date;
	 
	 public Transaction() {
		 
	 }
	 
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public Transaction(Long customerId, double amount, LocalDate date) {
		super();
		this.customerId = customerId;
		this.amount = amount;
		this.date = date;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, customerId, date);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(customerId, other.customerId) && Objects.equals(date, other.date);
	}
	@Override
	public String toString() {
		return "Transaction [customerId=" + customerId + ", amount=" + amount + ", date=" + date + "]";
	}
	    
	    
}
