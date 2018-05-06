package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.BerlinClock;
import com.ubs.opsit.interviews.exception.UnsupportedDateFormatException;
import com.ubs.opsit.interviews.exception.ValueOutOfRangeException;

/**
 * JUnit class for BerlinClock class.
 * 
 * @author Aavesh Yadav
 *
 */
public class BerlinClockImplTest {

	private BerlinClock classUnderTest;

	@Before
	public void init() {
		classUnderTest = new BerlinClockImpl();
	}

	@Test
	public void whenDateIsInHHmmssFormatThenReturnCompleteDateInBerlinClockFormat() {
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
		Assert.assertEquals("O\r\nRRRR\r\nRRRO\r\nYYRYYRYYRYY\r\nYYYY", classUnderTest.convertTime("23:59:59"));
	}

	@Test
	public void whenOnlyHoursPartIsGivenThenReturnHoursPartOnly() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * RRRR 
		 * RRRO
		 * 
		 */
		Assert.assertEquals("RRRR\r\nRRRO", classUnderTest.getHoursInBerlinClock(23));
	}

	@Test
	public void whenOnlyMinutesPartIsGivenThenReturnMinutesPartOnly() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * YYRYYRYYRYY 
		 * YYYY
		 * 
		 */
		Assert.assertEquals("YYRYYRYYRYY\r\nYYYY", classUnderTest.getMinutesInBerlinClock(59));
	}

	@Test
	public void whenSecondsPartIsOddThenReturnSecondsPartAsO() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * O
		 * 
		 */
		Assert.assertEquals("O", classUnderTest.getSecondsInBerlinClock(59));
	}

	@Test
	public void whenSecondsPartIsEvenThenReturnSecondsPartAsY() {
		/**
		 * EXPECTED OUTPUT 
		 * ---------------
		 * 
		 * Y
		 * 
		 */
		Assert.assertEquals("Y", classUnderTest.getSecondsInBerlinClock(20));
	}

	@Test(expected = UnsupportedDateFormatException.class)
	public void whenDateFormatIsIncorrectThenUnsupportedDateFormatExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * UnsupportedDateFormatException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.convertTime("23:59"));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void whenHourValueIsLessThan0ThenValueOutOfRangeExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * ValueOutOfRangeException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.getHoursInBerlinClock(-1));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void whenHourValueIsMoreThan23ThenValueOutOfRangeExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * ValueOutOfRangeException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.getHoursInBerlinClock(25));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void whenMinuteValueIsLessThan0ThenValueOutOfRangeExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * ValueOutOfRangeException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.getMinutesInBerlinClock(-1));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void whenMinutesValueIsMoreThan59ThenValueOutOfRangeExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * ValueOutOfRangeException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.getMinutesInBerlinClock(60));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void whenSecondsValueIsLessThan0ThenValueOutOfRangeExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * ValueOutOfRangeException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.getSecondsInBerlinClock(-1));
	}
	
	@Test(expected = ValueOutOfRangeException.class)
	public void whenSecondsValueIsMoreThan59ThenValueOutOfRangeExceptionShouldBeThrown() {
		/**
		 * EXPECTED OUTPUT
		 * ---------------
		 * 
		 * ValueOutOfRangeException should be thrown
		 * 
		 */
		Assert.assertEquals("", classUnderTest.getSecondsInBerlinClock(60));
	}
}
