package com.ubs.opsit.interviews.util;

/**
 * A constant class having all the constant values.
 * 
 * @author Aavesh Yadav
 *
 */
public class Constants {

	/**
	 * NEW_LINE constant.
	 */
	public static final String NEW_LINE = "\r\n";

	/**
	 * HOUR_FIRST_LINE constant.
	 */
	public static final String HOURS_FIRST_ROW = "OOOO";

	/**
	 * HOUR_SECOND_LINE constant.
	 */
	public static final String HOURS_SECOND_ROW = "OOOO";

	/**
	 * MINUTES_FIRST_ROW constant.
	 */
	public static final String MINUTES_FIRST_ROW = "OOOOOOOOOOO";

	/**
	 * MINUTES_SECOND_ROW constant.
	 */
	public static final String MINUTES_SECOND_ROW = "OOOO";

	/**
	 * DIVISOR_5 constant.
	 */
	public static final int DIVISOR_5 = 5;

	/**
	 * LIGHT_OFF constant.
	 */
	public static final String LIGHT_OFF = "O";

	/**
	 * COLON constant.
	 */
	public static final String COLON = ":";

	class ValidationMessage {
		public static final String INVALID_DATE_FORMAT = "Supproted date format is HH:mm:ss but is %s";
		public static final String HOURS_VALIDATION_ERROR = "The value of hours is invalid.";
		public static final String MINUTES_VALIDATION_ERROR = "The value of minutes is invalid.";
		public static final String SECONDS_VALIDATION_ERROR = "The value of seconds is invalid.";
	}
}
