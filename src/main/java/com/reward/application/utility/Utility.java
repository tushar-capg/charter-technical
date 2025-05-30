package com.reward.application.utility;

import java.util.Calendar;
import java.util.Date;
/**
 * Represents an Utility class.
 * Used to work on common utility functions.
 */
public class Utility {
	
	public static Date getDate(int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day); 
        return calendar.getTime();
	}
}
