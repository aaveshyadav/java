package com.ubs.opsit.interviews.util;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import com.ubs.opsit.interviews.exception.UnsupportedDateFormatException;
import com.ubs.opsit.interviews.exception.ValueOutOfRangeException;

/**
 * A validation utility class.
 * 
 * @author Aavesh Yadav
 *
 */
public final class ValidationUtil {

	/**
	 * The private constructor.
	 */
	private ValidationUtil() {

	}

	public static void validateDateFormat(String aTime) {
		int[] aTimeArr = Stream.of(aTime.split(Constants.COLON)).mapToInt(Integer::parseInt).toArray();
		if (aTimeArr.length != 3) {
			throw new UnsupportedDateFormatException(String.format(Constants.ValidationMessage.INVALID_DATE_FORMAT, aTime));
		}
	}

	public static void validateDateRange(int value, TimeUnit timeUnit) {
		if (timeUnit == TimeUnit.HOURS && (value < 0 || value > 24)) {
			throw new ValueOutOfRangeException(Constants.ValidationMessage.HOURS_VALIDATION_ERROR);
		}

		if (timeUnit == TimeUnit.MINUTES && (value < 0 || value > 59)) {
			throw new ValueOutOfRangeException(Constants.ValidationMessage.MINUTES_VALIDATION_ERROR);
		}

		if (timeUnit == TimeUnit.SECONDS && (value < 0 || value > 59)) {
			throw new ValueOutOfRangeException(Constants.ValidationMessage.SECONDS_VALIDATION_ERROR);
		}
	}
}
