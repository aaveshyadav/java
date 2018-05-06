package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.TimeConverter;
import com.ubs.opsit.interviews.exception.UnsupportedDateFormatException;

/**
 * JUnit class for TimeConverterImpl class.
 * 
 * @author Aavesh Yadav
 *
 */
public class TimeConverterImplTest {

	private TimeConverter timeConverter;

	@Before
	public void init() {
		timeConverter = new TimeConverterImpl();
	}

	@Test
	public void whenTimeIsSpecifiedInHHmmssFormatThenRetunTheConvertedDateInBerlinClock() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * O
		 * RRRR
		 * RRRO
		 * YYRYYRYYRYY
		 * YYYY
		 * 
		 */
		Assert.assertEquals("O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY", timeConverter.convertTime("23:59:59"));
	}
	
	@Test(expected = UnsupportedDateFormatException.class)
	public void whenIncorrectTimeIsSpecifiedThenAnExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * UnsupportedDateFormatException should be thrown
		 * 
		 */
		Assert.assertEquals("", timeConverter.convertTime("23:59"));
	}
}
