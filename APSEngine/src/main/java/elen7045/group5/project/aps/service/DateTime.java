package elen7045.group5.project.aps.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.StringTokenizer;

import elen7045.group5.project.InvalidDataException;

/**
 * This class provides utility functions relating to date and time
 * values. Note that these date validations, values, etc. are related
 * to the Gregorian calendar and conform to the 
 * <a href="http://www.w3.org/TR/xmlschema-2/#isoformats"><b>ISO 8601</b></a>
 */
public final class DateTime
{
	/**
	 * Indicates what format the date passed will be in
	 */
	public static final int FORMAT_YYYYMMDD = 1;
	
	/**
	 * Indicates what format the date passed will be in
	 */
	public static final int FORMAT_DDMMYYYY = 2;
		
	/**
	 * This method returns the current day of the week. Note that the value
	 * returned for Sunday=0, Monday=1, and so on.
	 */
	public static int getDayOfWeek()
	{
		int retVal = -1;
		GregorianCalendar cal = new GregorianCalendar();
		int dow = cal.get(Calendar.DAY_OF_WEEK);
		switch(dow)
		{
			case Calendar.SUNDAY:
				retVal = 0;
				break;
			case Calendar.MONDAY:
				retVal = 1;
				break;
			case Calendar.TUESDAY:
				retVal = 2;
				break;
			case Calendar.WEDNESDAY:
				retVal = 3;
				break;
			case Calendar.THURSDAY:
				retVal = 4;
				break;
			case Calendar.FRIDAY:
				retVal = 5;
				break;
			case Calendar.SATURDAY:
				retVal = 6;
				break;		
		}
		
		return retVal;
	}
	
	/**
	 * This returns the current date and time in the format YYYYMMDDHHMMSS
	 */
	public static String getStringNowDateTime()
	{
		String dt = DateTime.getStringNowDateTimeMilli();
		return dt.substring(0, 14);		
	}
	
	/**
	 * This returns the current date and time in the format YYYYMMDDHHMMSSsss
	 */
	public static String getStringNowDateTimeMilli()
	{
		GregorianCalendar cal = new GregorianCalendar();
		StringBuffer dateBuffer = new StringBuffer();
		dateBuffer.append(cal.get(Calendar.YEAR));
		//for the month, it starts at 0 for Jan, 1 for Feb, etc. so need to take this into 
		//account, also need to check if we need to add a zero to the front if not more than
		//10
		int month = cal.get(Calendar.MONTH);
		if (month < 9)
		{
			//add a zero at the front
			dateBuffer.append("0");
		}
		dateBuffer.append((month + 1));
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day <= 9)
		{
			dateBuffer.append("0");
		}
		dateBuffer.append(day);
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour < 10)
		{
			dateBuffer.append("0");
		}
		dateBuffer.append(Integer.toString(hour));
		
		//need to check the minute as well, if we get 0 then only one shows up, we need two
		int min = cal.get(Calendar.MINUTE);
		if (min < 10)
		{
			dateBuffer.append("0"); //add extra zero
		}
		dateBuffer.append(min);

		//CHECK SECONDS
		int sec = cal.get(Calendar.SECOND);
		if (sec < 10)
		{
			dateBuffer.append("0"); //add extra zero
		}
		dateBuffer.append(sec);
		dateBuffer.append(cal.get(Calendar.MILLISECOND));

		return dateBuffer.toString();
	}
	
	/**
	 * This returns the current date and time in a format that is defined by ISO 8601, which is 
	 * CCYY-MM-DDThh:mm:ss. Note that this time does <b>not</b> include the timezone. More info 
	 * can be found at <a href="http://www.w3.org/TR/xmlschema-2/#ISO8601">http://www.w3.org/TR/xmlschema-2/#ISO8601</a>
	 * @return An ISO formatted date/time
	 */
	public static String getNowISODateTime()
	{
		String dt = DateTime.getNowISODateTimeMilli();
		return dt.substring(0, 19);
	}
	
	/**
	 * This returns the current date and time (including milliseconds) in a format that is defined
	 * by ISO 8601, which is CCYY-MM-DDThh:mm:ss:sss. Note that this time does <b>not</b> include
	 * the timezone. More info can be found at <a href="http://www.w3.org/TR/xmlschema-2/#ISO8601">http://www.w3.org/TR/xmlschema-2/#ISO8601</a>
	 * @return An ISO formatted date/time
	 */
	public static String getNowISODateTimeMilli()
	{
		GregorianCalendar cal = new GregorianCalendar();
		StringBuffer dateBuffer = new StringBuffer();
		dateBuffer.append(cal.get(Calendar.YEAR));
		dateBuffer.append("-");
		//for the month, it starts at 0 for Jan, 1 for Feb, etc. so need to take this into 
		//account, also need to check if we need to add a zero to the front if not more than
		//10
		int month = cal.get(Calendar.MONTH);
		if (month < 9)
		{
			//add a zero at the front
			dateBuffer.append("0");
		}
		dateBuffer.append((month + 1));
		dateBuffer.append("-");

		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day <= 9)
		{
			dateBuffer.append("0");
		}
		dateBuffer.append(day);
		dateBuffer.append("T");

		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (hour < 10)
		{
			dateBuffer.append("0");
		}
		dateBuffer.append(Integer.toString(hour));
		dateBuffer.append(":");

		//need to check the minute as well, if we get 0 then only one shows up, we need two
		int min = cal.get(Calendar.MINUTE);
		if (min < 10)
		{
			dateBuffer.append("0"); //add extra zero
		}
		dateBuffer.append(min);

		//CHECK SECONDS
		dateBuffer.append(":");
		int sec = cal.get(Calendar.SECOND);
		if (sec < 10)
		{
			dateBuffer.append("0"); //add extra zero
		}
		dateBuffer.append(sec);
		
		//CHECK MILLISECONDS
		dateBuffer.append(":");
		int milsec = cal.get(Calendar.MILLISECOND);
		if(milsec < 10)
		{
			dateBuffer.append("00"); //add 2 extra zero
		}
		else if(milsec < 100)
		{
			dateBuffer.append("0");
		}
		dateBuffer.append(milsec);

		return dateBuffer.toString();
	}

	/**
	 * This returns the current date as defined in ISO 8601, which is CCYY-MM-DD. More info can be found at
	 * <a href="http://www.w3.org/TR/xmlschema-2/#ISO8601">http://www.w3.org/TR/xmlschema-2/#ISO8601</a>
	 * @return An ISO formatted date
	 */
	public static String getNowDate()
	{
		GregorianCalendar cal = new GregorianCalendar();
		StringBuffer dateBuffer = new StringBuffer();
		dateBuffer.append(cal.get(Calendar.YEAR));
		dateBuffer.append("-");
		//for the month, it starts at 0 for Jan, 1 for Feb, etc. so need to take this into 
		//account, also need to check if we need to add a zero to the front if not more than
		//10
		int month = cal.get(Calendar.MONTH);
		if (month < 9)
		{
			//add a zero at the front
			dateBuffer.append("0");
		}
		dateBuffer.append((month + 1));
		dateBuffer.append("-");

		int day = cal.get(Calendar.DAY_OF_MONTH);
		if (day <= 9)
		{
			dateBuffer.append("0");
		}
		dateBuffer.append(day);

		return dateBuffer.toString();
	}

	/**
	 * This function checks if the user has entered in a valid date, i.e. correct
	 * day, month, year as well as leap years.
	 * 
	 * @param dateString - The entire date entered on the web page
	 * @param dateSeparator - The separator used in the date string, e.g "/", "-",
	 * if no separator exists, null can be passed.
	 * @param format - One of the static values in this class, indicates the order
	 * of the days/months
	 */
	public static boolean isDateValid(String dateString, String dateSeparator, int format)
	{
		precondition(dateString != null, "Date passed cannot be null");
		precondition((format == DateTime.FORMAT_DDMMYYYY || format == DateTime.FORMAT_YYYYMMDD), 
						"Date format passed must be one of the predefined formats found in this class");
		
		String dayStr = null;
		String monthStr = null;
		String yearStr = null;
		boolean isVal = true;				
		if(dateString.length() < 8)
		{
			isVal = false;
		}
		else
		{	
			try
			{
				if(dateSeparator == null)
				{
					switch(format)
					{
						case DateTime.FORMAT_DDMMYYYY:
							dayStr = dateString.substring(0, 2);
							monthStr = dateString.substring(2, 4);
							yearStr = dateString.substring(4);
							break;
						case DateTime.FORMAT_YYYYMMDD:
							yearStr = dateString.substring(0, 4);
							monthStr = dateString.substring(4, 6);
							dayStr = dateString.substring(6);
							break;
					}
				}
				else
				{
					StringTokenizer st = new StringTokenizer(dateString, dateSeparator);
					switch(format)
					{
						case DateTime.FORMAT_DDMMYYYY:
							dayStr = st.nextToken();
							monthStr = st.nextToken();
							yearStr = st.nextToken();
							break;
						case DateTime.FORMAT_YYYYMMDD:
							yearStr = st.nextToken();
							monthStr = st.nextToken();
							dayStr = st.nextToken();
							break;					
					}				
				}
				
				int year = Integer.parseInt(yearStr);
				int month = Integer.parseInt(monthStr);
				int day = Integer.parseInt(dayStr);		
				
				GregorianCalendar gc = new GregorianCalendar(year, month, day);
				//check for leap year
				if(month == 2 && day == 29)
				{
					isVal = gc.isLeapYear(year);
				}
				else
				{
					//check day month combinations
					if ((month == 1 & day > 31)
						|| (month == 2 & day > 28)
						|| (month == 3 & day > 31)
						|| (month == 4 & day > 30)
						|| (month == 5 & day > 31)
						|| (month == 6 & day > 30)
						|| (month == 7 & day > 31)
						|| (month == 8 & day > 31)
						|| (month == 9 & day > 30)
						|| (month == 10 & day > 31)
						|| (month == 11 & day > 30)
						|| (month == 12 & day > 31))
					{
						isVal = false;
					}
				}				
			}
			catch(NumberFormatException nfe)
			{
				isVal = false;
			}		
		}

		return isVal;
	}
	
	/**
	 * This method checks for any preconditions that need to be satisfied when 
	 * entering methods. If the condition passed is false, this method throws 
	 * a InvalidDataException (extends RuntimeException) containing <code>msg</code>.
	 * @param cond - A condition that needs to be false in order to succeed
	 * @param msg - Any message that must be included in the passed exception
	 */
	private static void precondition(boolean cond, String msg)
	{
		if (!cond)
			throw new InvalidDataException("DateTime: " + msg);
	}
}