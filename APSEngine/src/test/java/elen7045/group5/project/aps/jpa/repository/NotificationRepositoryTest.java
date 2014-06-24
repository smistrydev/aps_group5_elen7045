package elen7045.group5.project.aps.jpa.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import elen7045.group5.project.aps.jpa.config.ApplicationContext;
import elen7045.group5.project.aps.jpa.model.Notification;
import elen7045.group5.project.aps.jpa.service.NotificationService;

/**
 * 
 * @author Sanjay Mistry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
public class NotificationRepositoryTest
{

	@Autowired
	private NotificationService	notificationService;

	/**
	 * Test method for {@link com.sanjay.test.jpa.model.Notification#toString()}
	 * .
	 */
	@Test
	public void testNotificationGetAll()
	{
		Iterable<Notification> notifications = notificationService.findAll();

		assertNotNull(notifications);
		assertTrue(notifications.iterator().hasNext());

	}

	@Test
	public void testNotificationGetOne()
	{
		
		Integer testId = new Integer(3);
		Notification notification = notificationService.findById(testId);

		assertNotNull(notification);

	}

}
