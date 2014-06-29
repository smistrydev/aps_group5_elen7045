/**
 * 
 */
package elen7045.group5.project.notify;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import elen7045.group5.project.aps.config.ApplicationContext;
import elen7045.group5.project.notify.service.IApplicationNotificationService;
import elen7045.group5.project.notify.service.NotificationMessage;
import elen7045.group5.project.notify.service.NotificationXMLUtil;

/**
 * 
 * @author Sanjay Mistry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
public class ApplicationNotificationTest
{

	@Autowired
	IApplicationNotificationService	applicationNotificationService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}

	/**
	 * Test method for
	 * {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EApplicationErrors)}
	 * .
	 * 
	 * @throws JAXBException
	 */
	@Test
	public void testXmlNotificationMessageEApplicationErrors() throws JAXBException
	{

		EApplicationErrors applicationErrors = EApplicationErrors.ACTION_REQUIRED_BY_BILLING_WEBSITE;
		String xml = applicationNotificationService.notificationMessageToXML(applicationErrors);

		assertNotNull(xml);

		NotificationMessage message = NotificationXMLUtil.fromXML(xml);
		assertEquals("2004", message.getNotificationCode());
		assertEquals("ACTION_REQUIRED_BY_BILLING_WEBSITE", message.getNotificationMessage());

	}

	/**
	 * Test method for
	 * {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EUserInterfaceErrors)}
	 * .
	 * 
	 * @throws JAXBException
	 */
	@Test
	public void testXmlNotificationMessageEUserInterfaceErrors() throws JAXBException
	{
		EUserInterfaceErrors userInterfaceErrors = EUserInterfaceErrors.INVALID_USER_NAME;
		String xml = applicationNotificationService.notificationMessageToXML(userInterfaceErrors);

		assertNotNull(xml);

		NotificationMessage message = NotificationXMLUtil.fromXML(xml);

		assertEquals("0001", message.getNotificationCode());
		assertEquals("INVALID_USER_NAME", message.getNotificationMessage());

	}

	/**
	 * Test method for
	 * {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EScrapperSchedularErrors)}
	 * .
	 * @throws JAXBException 
	 */
	@Test
	public void testXmlNotificationMessageEScrapperSchedularErrors() throws JAXBException
	{
		EScrapperSchedularErrors scrapperSchedularErrors = EScrapperSchedularErrors.SCHEDULER_REACHED_MAXIMUM_RETRIES;
		String xml = applicationNotificationService.notificationMessageToXML(scrapperSchedularErrors);

		assertNotNull(xml);
		
		NotificationMessage message = NotificationXMLUtil.fromXML(xml);
		
		assertEquals("3002", message.getNotificationCode());
		assertEquals("SCHEDULER_REACHED_MAXIMUM_RETRIES", message.getNotificationMessage());

	}

	/**
	 * Test method for
	 * {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EDataErrors)}
	 * .
	 * @throws JAXBException 
	 */
	@Test
	public void testXmlNotificationMessageEDataErrors() throws JAXBException
	{
		EDataErrors dataErrors = EDataErrors.DATA_FAILS_INTEGRITY_CHECKING;
		String xml = applicationNotificationService.notificationMessageToXML(dataErrors);

		assertNotNull(xml);
		
		NotificationMessage message = NotificationXMLUtil.fromXML(xml);
		
		assertEquals("1005", message.getNotificationCode());
		assertEquals("DATA_FAILS_INTEGRITY_CHECKING", message.getNotificationMessage());

	}

}
