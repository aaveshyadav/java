package com.ubs.opsit.interviews;

import java.util.concurrent.TimeUnit;

import com.ubs.opsit.interviews.util.BerlinClockUtil;

/**
 * This class represents the Berlin clock implementation.
 * 
 * @author Aavesh Yadav
 *
 */
public class BerlinClockImpl extends BerlinClock {

	/**
	 * Returns the hour part of the Berlin clock.
	 * 
	 * @return the hours value
	 */
	protected String getHoursInBerlinClock(int hour) {
		return BerlinClockUtil.get(hour, TimeUnit.HOURS);
	}

	/**
	 * Returns the minute part of the Berlin clock.
	 * 
	 * @return the minutes value
	 */
	protected String getMinutesInBerlinClock(int minute) {
		return BerlinClockUtil.get(minute, TimeUnit.MINUTES);
	}

	/**
	 * Returns the second part of the Berlin clock.
	 * 
	 * @return the seconds value
	 */
	protected String getSecondsInBerlinClock(int second) {
		return BerlinClockUtil.get(second, TimeUnit.SECONDS);
	}

}
