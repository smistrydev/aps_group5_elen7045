package elen7045.group5.project.aps.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import elen7045.group5.project.InvalidDataException;
import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.model.MaintenanceWindow;


/**
 * This class determines if a particular scheduled event/time has been reached. It is
 * modelled on crontab from UNIX. The class uses a {@link MaintenanceWindow} for all its checks,
 * the table below shows what is available and what the limits are for each field.
 * <table border="1" cellpadding="5" cellspacing="0">
 * <tbody>
 * 	<tr>
 * 		<th align="left">Field</th><th align="left">Limit</th>
 * 	</tr>
 *	<tr>
 *		<td>Minute</td><td>0-59</td>
 *	</tr>
 *	<tr>
 *		<td>Hour</td><td>2-24</td>
 *	</tr>
 *	<tr>
 *		<td>Day Of Month</td><td>1-31</td>
 *	</tr>
 *	<tr>
 *		<td>Month</td><td>1-12</td>
 *	</tr>
 *	<tr>
 *		<td>Day Of Week</td><td>0-6</td>
 *	</tr>
 *	</tbody>
 *	</table>
 *	<p>
 * There are several ways of specifying multiple values in a field:</p>
 * <p>
 * &#8226; The comma (',') operator specifies a list of values, for example: &quot;1,3,4,7,8&quot;<br>
 * &#8226; The dash ('-') operator specifies a range of values, for example: &quot;1-6&quot;, which is equivalent to &quot;1,2,3,4,5,6&quot;<br>
 * &#8226; The asterisk ('*') operator specifies all possible values for a field. e.g. every hour or every day. This is the default
 */
public class Scheduler
{
	private final String TYPE_MIN = "MINUTES";
	private final String TYPE_HOUR = "HOURS";
	private final String TYPE_MONTH = "MONTHS";
	private final String TYPE_DOM = "DAYS_OF_MONTH";
	private final String TYPE_DOW = "DAYS_OF_WEEK";
	
	/**
	 * This method will determine if a scrape operation is allowed based on scheduling and
	 * the statement cycles of various Billing Companies.
	 * @param bc - Billing Company whose cycles need to be checked
	 * @return Returns true if a scrape is allowed, false otherwise
	 */
	public boolean isScrapeAllowed(BillingCompany bc)
	{
		boolean scrape = false;
		GregorianCalendar now = new GregorianCalendar();
		long nextStatementDt = bc.getStatementDate().getTime() + getMilliSecondsForDays(bc.getDaysPerCycle()) 
									- getMilliSecondsForDays(bc.getLeadTimeDays());
		
		if(nextStatementDt >= now.getTimeInMillis())  
		{
			if(isScheduledTimeReached(bc.getMaintenanceWindows()) == false)
			{
				scrape = true;
			}
		}
		
		return scrape;
	}
	
	
	/**
	 * Method would check if a schedule is reached across a number of maintenance windows
	 * @param schedList - List of MaintenanceWindows to check
	 * @return Returns true if any one of the windows in the passed object has reached its
	 * schedule, false otherwise
	 */
	public boolean isScheduledTimeReached(List<MaintenanceWindow> schedList)
	{
		boolean isReached = false;
		for(MaintenanceWindow mw : schedList)
		{
			if(isScheduledTimeReached(mw))
			{
				isReached = true;
				break;
			}
		}
		
		return isReached;		
	}
	
	/**
	 * This method checks if the data contained in the passed bean equates to the
	 * current time (within the same minute).
	 * @param sched - Bean containing all the scheduled information
	 * @return Returns true if the passed data matches the current time, false
	 * otherwise 
	 */
	public boolean isScheduledTimeReached(MaintenanceWindow sched) throws InvalidDataException
	{
		precondition(sched != null, "Maintenance bean passed cannot be null");
		String dt = DateTime.getStringNowDateTime();
		boolean scheduled = false; //reset		
		
		ArrayList<String> minutes = splitInfo(sched.getMinute(), TYPE_MIN);
		if(isMatch(minutes, dt.substring(10, 12)))
		{
			ArrayList<String> hours = splitInfo(sched.getHour(), TYPE_HOUR);
			if(isMatch(hours, dt.substring(8, 10)))
			{
				ArrayList<String> dom = splitInfo(sched.getDay(), TYPE_DOM);
				if(isMatch(dom, dt.substring(6, 8)))
				{
					ArrayList<String> month = splitInfo(sched.getMonth(), TYPE_MONTH);
					if(isMatch(month, dt.substring(4, 6)))
					{
						scheduled = true;
					}
				}
			}
		}	
		
		return scheduled;
	}
	
	/**
	 * This method indicates if the passed list contains a value that is
	 * equals to the matchVal 
	 * @param vals - List of String values
	 * @param matchVal - Value to match against the list
	 * @return Returns true if a match in the list is found, false otherwise
	 */
	private boolean isMatch(ArrayList<String> vals, String matchVal)
	{
		boolean match = false;
		
		String str = null;
		//if matchVal starts with 0, remove it
		int noZero = Integer.parseInt(matchVal);
		Iterator<String> it = vals.iterator();
		while(it.hasNext())
		{
			str = it.next();
			if(str.equals("*"))
			{
				match = true;
				break;
			}
			else
			{				
				if(str.equals(Integer.toString(noZero)))
				{
					match = true;
					break;
				}		
			}
		}
		
		return match;
	} 
	
	/**
	 * Method parses the info passed into separate values. Values can be separated
	 * by commas or "-" to indicate a range. 
	 * @param dat
	 * @return Returns a list of values entered by the user
	 */
	private ArrayList<String> splitInfo(String dat, String typeCheck) throws InvalidDataException
	{
		ArrayList<String> values = new ArrayList<String>();		
		if(dat.equals("*"))
		{
			values.add(dat);
		}
		else
		{
			String[] splitzDash = null;
			String[] splitzCom = dat.split(",");
			for(int r = 0; r < splitzCom.length; r++)
			{
				//check the string for range values
				splitzDash = splitzCom[r].split("-");
				try
				{
					if(splitzDash.length == 1) //no range
					{
						int intVal = Integer.parseInt(splitzDash[0]);
						validate(intVal, typeCheck);
						values.add(splitzDash[0]);
					}
					else if(splitzDash.length == 2)
					{
						int first = Integer.parseInt(splitzDash[0]);
						int second = Integer.parseInt(splitzDash[1]);
						
						validate(first, typeCheck);
						values.add(splitzDash[0]);
						
						//add the range
						for(int b = first + 1; b < second; b++)
						{
							values.add(Integer.toString(b));
						}						
						
						validate(second, typeCheck);
						values.add(splitzDash[1]);						
					}
				}
				catch(NumberFormatException nfe)
				{
					throw new InvalidDataException("Number entered is invalid. Field="
														+ typeCheck);
				}
			}
		}
		
		return values;
	}
	
	/**
	 * Checks if the passed value falls within the range of the particular type passed
	 * (minutes, hours, etc)
	 * @param val - Value entered by user
	 * @param typeCheck - Indicates minutes, hours, etc.
	 */
	private void validate(int val, String typeCheck) throws InvalidDataException
	{
		boolean invalid = false;
		
		if(typeCheck.equals(TYPE_MIN))
		{
			if(val > 59 || val < 0)
			{
				invalid = true;
			}			
		}
		else if(typeCheck.equals(TYPE_HOUR))
		{
			if(val < 0 || val > 23)
			{
				invalid = true;
			}			
		}
		else if(typeCheck.equals(TYPE_DOM))
		{
			if(val < 1 || val > 31)
			{
				invalid = true;
			}
		}
		else if(typeCheck.equals(TYPE_MONTH))
		{
			if(val < 1 || val > 12)
			{
				invalid = true;
			}
		}
		else if(typeCheck.equals(TYPE_DOW))
		{
			if(val < 0 || val > 7)
			{
				invalid = true;
			}
		}
		else
		{
			invalid = true;
		}
				
		if(invalid)
		{
			throw new InvalidDataException("Number entered is invalid. Number="
														+ val + ", Field="
														+ typeCheck); 
		}
	}
	
	/**
	 * Calculates how many milliseconds are in the number of days
	 * passed
	 * @param days - Number of days
	 * @return Returns how many milliseconds are in the number of days
	 * passed
	 */
	private long getMilliSecondsForDays(int days)
	{
		return days * 24 * 3600 * 1000;
	}
	
	/**
	 * This method checks for any preconditions that need to be satisfied when 
	 * entering methods. If the condition passed is false, this method throws 
	 * a InvalidDataException (extends RuntimeException) containing <code>msg</code>.
	 * @param cond A condition that needs to be false in order to succeed
	 * @param msg Any message that must be included in the passed exception
	 */
	private void precondition(boolean cond, String msg) 
	{
		if(!cond) throw new InvalidDataException(this + ": " + msg);
	}
}
