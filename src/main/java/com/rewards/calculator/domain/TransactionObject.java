package com.rewards.calculator.domain;

public class TransactionObject {

	private String customerId;
	
	private Integer transactionValue;
	
	private String transactionDate;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Integer getTransactionValue() {
		return transactionValue;
	}

	public void setTransactionValue(Integer transactionValue) {
		this.transactionValue = transactionValue;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
}
