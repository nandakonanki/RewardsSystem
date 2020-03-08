package com.rewards.calculator.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rewards.calculator.constants.RewardsConstants;
import com.rewards.calculator.domain.TransactionObject;
import com.rewards.calculator.util.RewardsUtil;

public class TransactionService {

	private Integer calculateRewards(int price) {
		int rewardsEarned = RewardsConstants.INITIAL_INT_VALUE;
		if (price >= RewardsConstants.REWARD_POINTS_SEGMENT1 && price < RewardsConstants.REWARD_POINTS_SEGMENT2) {
			rewardsEarned = (price % RewardsConstants.REWARD_POINTS_SEGMENT1) * RewardsConstants.REWARD_POINTS_FOR_50;
		} else if (price >= RewardsConstants.REWARD_POINTS_SEGMENT2) {
			rewardsEarned = (RewardsConstants.REWARD_POINTS_FOR_100 * (price - RewardsConstants.REWARD_POINTS_SEGMENT2)
					+ 50);
		}
		return rewardsEarned;
	}

	public Map getRewardsSummaryForGivenMonths(List<TransactionObject> transactionList, Integer lastMonths) {
		Map<String, Integer> summaryDetails = new HashMap<>();
		for (TransactionObject transactionObject : transactionList) {
			if (RewardsUtil.dateWithinGivenMonths(transactionObject.getTransactionDate(), lastMonths)) {
				int calculatedRewards = calculateRewards(transactionObject.getTransactionValue());
				summaryDetails.put(transactionObject.getCustomerId(),
						summaryDetails.getOrDefault(transactionObject.getCustomerId(),
								RewardsConstants.INITIAL_INT_VALUE) + calculatedRewards);
			}
		}
		return summaryDetails;
	}
}
