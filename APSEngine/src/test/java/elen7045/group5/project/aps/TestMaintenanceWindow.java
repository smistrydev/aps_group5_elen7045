package elen7045.group5.project.aps;

import static org.junit.Assert.*;

import org.junit.Test;

import elen7045.group5.project.aps.jpa.model.MaintenanceWindow;
import elen7045.group5.project.aps.service.Scheduler;

/**
 * Tests if the scheduler gives a correct response for when a scheduled time is reached
 */
public class TestMaintenanceWindow
{

	/**
	 * Test method for {@link elen7045.group5.project.aps.service.Scheduler#isScheduledTimeReached(ScheduleBean)}.
	 */
	@Test
	public void testIsScheduledTimeReached()
	{
		Scheduler sched = new Scheduler();
		MaintenanceWindow mw = new MaintenanceWindow();
		mw.setMinute("50-59");
		mw.setHour("23");
		mw.setMonth("7,13");		
		boolean yes = sched.isScheduledTimeReached(mw);
		assertFalse(yes);
	}
}
