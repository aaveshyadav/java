package com.ubs.opsit.interviews.util;

import java.util.concurrent.TimeUnit;

import com.ubs.opsit.interviews.Color;

/**
 * A utility class having the methods to convert the simple date to Berlin date
 * format.
 * 
 * @author Aavesh Yadav
 *
 */
public final class BerlinClockUtil {

	/**
	 * The private constructor.
	 */
	private BerlinClockUtil() {
	}

	/**
	 * This method returns the converted part of the given time unit into Berlin
	 * clock format.
	 * 
	 * @param value
	 *            the value of the time unit
	 * @param timeUnit
	 *            the TimeUnit instance
	 * @return the Berlin formatted date
	 */
	public static String get(int value, TimeUnit timeUnit) {
		// Validate the values of the date parts
		ValidationUtil.validateDateRange(value, timeUnit);

		switch (timeUnit) {
		case HOURS:
			return getHours(value);
		case MINUTES:
			return getMinutes(value);
		case SECONDS:
			return getSeconds(value);
		default:
			break;
		}
		return "";
	}

	/**
	 * Returns the hours part in berlin clock format.
	 * 
	 * @param hour
	 *            value of the hour part
	 * @return the hours part
	 */
	private static String getHours(int hour) {
		int noOfLightsInFirstRow = getNoOfLightsInFirstRow(hour);
		int noOfLightsInSecondRow = getNoOfLightsInSecondRow(hour);

		StringBuilder sb = new StringBuilder();

		sb.append(getFormattedData(Constants.HOURS_FIRST_ROW, noOfLightsInFirstRow, TimeUnit.HOURS));
		sb.append(Constants.NEW_LINE);
		sb.append(getFormattedData(Constants.HOURS_SECOND_ROW, noOfLightsInSecondRow, TimeUnit.HOURS));

		return sb.toString();
	}

	/**
	 * Returns the minutes part in berlin clock format.
	 * 
	 * @param minute
	 *            value of the minute part
	 * @return the minutes part
	 */
	private static String getMinutes(int minute) {
		int noOfLightsInFirstRow = getNoOfLightsInFirstRow(minute);
		int noOfLightsInSecondRow = getNoOfLightsInSecondRow(minute);

		StringBuilder sb = new StringBuilder();

		sb.append(getFormattedData(Constants.MINUTES_FIRST_ROW, noOfLightsInFirstRow, TimeUnit.MINUTES));
		sb.append(Constants.NEW_LINE);
		sb.append(getFormattedData(Constants.MINUTES_SECOND_ROW, noOfLightsInSecondRow, TimeUnit.MINUTES));

		return sb.toString();
	}

	/**
	 * Returns the seconds part in berlin clock format.
	 * 
	 * @param value
	 *            value of the seconds part
	 * @return the seconds part
	 */
	private static String getSeconds(int value) {
		if (value % 2 == 0) {
			return Color.YELLOW.getCode();
		} else {
			return Constants.LIGHT_OFF;
		}
	}

	/**
	 * This method returns the formatted value of the given time unit.
	 * 
	 * @param value
	 *            the value of the time unit
	 * @param size
	 *            the size up to which actual color should be replaced
	 * @param timeUnit
	 *            the TimeUnit instance
	 * @return the formatted date
	 */
	private static String getFormattedData(String value, int size, TimeUnit timeUnit) {
		StringBuilder sb = new StringBuilder(value);
		for (int i = 0; i < size; i++) {
			if (timeUnit == TimeUnit.HOURS) {
				sb.replace(i, i + 1, Color.RED.getCode());
			} else {
				// The red ones denoting 15, 30 and 45 minutes past
				if (value.equals(Constants.MINUTES_FIRST_ROW) && i % 3 == 2) {
					sb.replace(i, i + 1, Color.RED.getCode());
				} else {
					sb.replace(i, i + 1, Color.YELLOW.getCode());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * This method returns the no. of lights in first row.
	 * 
	 * @param value
	 *            the time unit value
	 * @return the no. of lights value
	 */
	private static int getNoOfLightsInFirstRow(int value) {
		return value / Constants.DIVISOR_5;
	}

	/**
	 * This method returns the number of lights in second row.
	 * 
	 * @param value
	 *            the time unit value
	 * @return the number of lights value
	 */
	private static int getNoOfLightsInSecondRow(int value) {
		return value % Constants.DIVISOR_5;
	}

}
