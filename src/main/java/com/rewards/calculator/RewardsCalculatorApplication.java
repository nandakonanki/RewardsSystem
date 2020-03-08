package com.rewards.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rewards.calculator.domain.TransactionObject;
import com.rewards.calculator.service.TransactionService;

public class RewardsCalculatorApplication {

	public static void main(String[] args) {

		TransactionService service = new TransactionService();

		Map<String, Integer> summaryTransactionMap = service.getRewardsSummaryForGivenMonths(getTransactionList(), -3);
		for (String key : summaryTransactionMap.keySet()) {
			System.out.println("Rewards Earned for " + key + ":" + summaryTransactionMap.get(key));
		}

	}

	/*
	 * We have to prepare the Data Set,if we want to change the accepted
	 * dateFormat change CURRENT_ALLOWED_TIME_FORMAT in RewardsConstants
	 */
	public static List<TransactionObject> getTransactionList() {
		List<TransactionObject> transactionList = new ArrayList<>();
		TransactionObject obj = new TransactionObject();
		obj.setCustomerId("123");
		obj.setTransactionDate("2020-02-25");
		obj.setTransactionValue(120);
		transactionList.add(obj);
		obj = new TransactionObject();
		obj.setCustomerId("1234");
		obj.setTransactionDate("2019-02-25");
		obj.setTransactionValue(850);
		transactionList.add(obj);
		obj = new TransactionObject();
		obj.setCustomerId("123");
		obj.setTransactionDate("2019-12-25");
		obj.setTransactionValue(120);
		transactionList.add(obj);
		obj = new TransactionObject();
		obj.setCustomerId("123");
		obj.setTransactionDate("2019-02-25");
		obj.setTransactionValue(120);
		transactionList.add(obj);
		obj = new TransactionObject();
		obj.setCustomerId("1234");
		obj.setTransactionDate("2020-02-25");
		obj.setTransactionValue(120);
		transactionList.add(obj);
		return transactionList;
	}

}
