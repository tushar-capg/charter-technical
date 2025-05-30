package com.reward.application.enumeration;

public enum MonthsEnum {
	
	JANUARY(1), FEBRUARY(2), MARCH(3), APRIL(4), MAY(5), JUNE(6),
    JULY(7), AUGUST(8), SEPTEMBER(9), OCTOBER(10), NOVEMBER(11), DECEMBER(12);

    private final int value;

    MonthsEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    // Method to get Month by Number
    public static MonthsEnum getMonth(int monthNumber) {
        for (MonthsEnum month : MonthsEnum.values()) {
            if (month.getValue() == monthNumber) {
                return month;
            }
        }
        throw new IllegalArgumentException("Invalid month number: " + monthNumber);
    }
}
