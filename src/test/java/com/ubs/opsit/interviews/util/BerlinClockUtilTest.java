package com.ubs.opsit.interviews.util;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;

import com.ubs.opsit.interviews.util.BerlinClockUtil;

/**
 * JUnit class for BerlinClockUtil class.
 * 
 * @author Aavesh Yadav
 *
 */
public class BerlinClockUtilTest {

	@Test
	public void whenTimeUnitAsHourIsGivenThenReturnHoursPart() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * RRRR
		 * RRRO
		 * 
		 */
		Assert.assertEquals("RRRR\r\nRRRO", BerlinClockUtil.get(23, TimeUnit.HOURS));
	}

	@Test
	public void whenTimeUnitAsMinutesIsGivenThenReturnMinutesPart() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * YYRYYRYYRYY
		 * YYYY
		 * 
		 */
		Assert.assertEquals("YYRYYRYYRYY\r\nYYYY", BerlinClockUtil.get(59, TimeUnit.MINUTES));
	}

	@Test
	public void whenTimeUnitAsSecondsWithOddValueIsGivenThenReturnSecondsPartAsO() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * O
		 * 
		 */
		Assert.assertEquals("O", BerlinClockUtil.get(59, TimeUnit.SECONDS));
	}

	@Test
	public void whenTimeUnitAsSecondsWithEvenValueIsGivenThenReturnSecondsPartAsY() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * Y
		 * 
		 */
		Assert.assertEquals("Y", BerlinClockUtil.get(20, TimeUnit.SECONDS));
	}

	@Test
	public void whenUnsupportedTimeUnitIsGivenThenReturnBlankString() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * <Blank String>
		 * 
		 */
		Assert.assertEquals("", BerlinClockUtil.get(23, TimeUnit.MILLISECONDS));
	}
}
