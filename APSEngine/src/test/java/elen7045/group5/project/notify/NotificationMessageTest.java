package elen7045.group5.project.notify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import javax.xml.bind.JAXBException;

import org.junit.Test;

import elen7045.group5.project.notify.service.NotificationMessage;
import elen7045.group5.project.notify.service.NotificationXMLUtil;

public class NotificationMessageTest
{

	@Test
	public void testNotificationMessageUtilMarshal() throws JAXBException
	{

		NotificationMessage notificationMessage = new NotificationMessage();
		notificationMessage.setNotificationCode("1000");
		notificationMessage.setNotificationMessage("Test");
		notificationMessage.setTimeStamp(new Date(1403988109593l));

		String xmlString = NotificationXMLUtil.toXML(notificationMessage);

		assertNotNull(xmlString);

		String xmlStringTest = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Notification><notificationCode>1000</notificationCode><notificationMessage>Test</notificationMessage><timeStamp>2014-06-28T22:41:49.593+02:00</timeStamp></Notification>";

		assertEquals(xmlStringTest, xmlString);

	}

	@Test
	public void testNotificationMessageUtilUnMarshal() throws JAXBException
	{
		String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Notification><notificationCode>1000</notificationCode><notificationMessage>Test</notificationMessage><timeStamp>2014-06-28T22:41:49.593+02:00</timeStamp></Notification>";

		NotificationMessage notificationMessage = NotificationXMLUtil.fromXML(xmlString);

		assertNotNull(notificationMessage);
		assertEquals("1000", notificationMessage.getNotificationCode());
		assertEquals("Test", notificationMessage.getNotificationMessage());
		assertNotNull(notificationMessage.getTimeStamp());
		assertEquals(new Date(1403988109593l), notificationMessage.getTimeStamp());


	}

}
