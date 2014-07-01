package elen7045.group5.project.aps.encrypt.service;

import static org.junit.Assert.*;

import org.junit.Test;

import elen7045.group5.project.aps.service.DateTime;

/**
 * Test is used to check if a date we create is valid
 */
public class DateTimeTest
{
	@Test
	public void testIsDateValid()
	{
		boolean withDtSep = DateTime.isDateValid("2014-09-29", "-", DateTime.FORMAT_YYYYMMDD);
		assertTrue(withDtSep);
		
		boolean leapYr = DateTime.isDateValid("2012-02-29", "-", DateTime.FORMAT_YYYYMMDD);
		assertTrue(leapYr);
		
		boolean noDtSep = DateTime.isDateValid("32060225", null, DateTime.FORMAT_DDMMYYYY);
		assertFalse(noDtSep);
		
		boolean rvers = DateTime.isDateValid("29.02.2004", ".", DateTime.FORMAT_DDMMYYYY);
		assertTrue(rvers);		
	}

}
