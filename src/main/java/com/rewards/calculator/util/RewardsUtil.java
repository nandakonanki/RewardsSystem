package com.rewards.calculator.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.rewards.calculator.constants.RewardsConstants;

public class RewardsUtil {

	public static final SimpleDateFormat sdfDate = new SimpleDateFormat(RewardsConstants.CURRENT_ALLOWED_TIME_FORMAT);

	public static String getTodaysDate() {
		return sdfDate.format(new Date());
	}

	public static boolean dateWithinGivenMonths(String dateToValidate, Integer months) {
		sdfDate.setLenient(false);
		try {
			Date givenDate = sdfDate.parse(dateToValidate);
			Calendar beforeThreeMonthsDate = Calendar.getInstance();
			beforeThreeMonthsDate.add(Calendar.MONTH, months);
			if (givenDate.after(beforeThreeMonthsDate.getTime())) {
				return true;
			} else {
				return false;
			}
		} catch (ParseException e) {
			e.printStackTrace();
			return false;
		}
	}
}
