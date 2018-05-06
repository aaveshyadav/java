package com.ubs.opsit.interviews;

/**
 * This class provides the implementation for the TimeConverter.
 * 
 * @author Aavesh Yadav
 *
 */
public class TimeConverterImpl implements TimeConverter {

	/**
	 * This method parses the given date and converts it to Berlin clock format.
	 */
	@Override
	public String convertTime(String aTime) {
		BerlinClock berlinClock = new BerlinClockImpl();
		return berlinClock.convertTime(aTime);
	}

}
