package com.ubs.opsit.interviews;

import java.util.stream.Stream;

import com.ubs.opsit.interviews.util.Constants;
import com.ubs.opsit.interviews.util.ValidationUtil;

/**
 * A template for Berlin clock implementation where the implementing classes can
 * provide their own implementations.
 * 
 * @author Aavesh Yadav
 *
 */
public abstract class BerlinClock {

	/**
	 * Converts the date into Berlin clock format.
	 * 
	 * @param aTime
	 * @return the Berlin date
	 */
	public final String convertTime(String aTime) {
		int[] aTimeArr = Stream.of(aTime.split(Constants.COLON)).mapToInt(Integer::parseInt).toArray();

		// Validate the input date format
		ValidationUtil.validateDateFormat(aTime);

		StringBuilder sb = new StringBuilder();

		sb.append(getSecondsInBerlinClock(aTimeArr[2]));
		sb.append(Constants.NEW_LINE);

		sb.append(getHoursInBerlinClock(aTimeArr[0]));
		sb.append(Constants.NEW_LINE);

		sb.append(getMinutesInBerlinClock(aTimeArr[1]));

		return sb.toString();
	}

	protected abstract String getHoursInBerlinClock(int hour);

	protected abstract String getMinutesInBerlinClock(int minute);

	protected abstract String getSecondsInBerlinClock(int second);

}