/**
 * 
 */
package elen7045.group5.project.notify;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import elen7045.group5.project.aps.config.ApplicationContext;
import elen7045.group5.project.notify.service.IApplicationNotificationService;

/**
 * 
 * @author Sanjay Mistry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
public class ApplicationNotificationTest
{

	@Autowired
	IApplicationNotificationService applicationNotificationService
	;
	
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
	 * Test method for {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EApplicationErrors)}.
	 */
	@Test
	public void testXmlNotificationMessageEApplicationErrors()
	{
		
		EApplicationErrors applicationErrors = EApplicationErrors.ACTION_REQUIRED_BY_BILLING_WEBSITE;
		String xml = applicationNotificationService.xmlNotificationMessage(applicationErrors);

		System.out.println(xml);
		
		assertNotNull(xml);
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EUserInterfaceErrors)}.
	 */
	//@Test
	public void testXmlNotificationMessageEUserInterfaceErrors()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EScrapperSchedularErrors)}.
	 */
	//@Test
	public void testXmlNotificationMessageEScrapperSchedularErrors()
	{
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link elen7045.group5.project.notify.service.ApplicationNotificationServiceImpl#xmlNotificationMessage(elen7045.group5.project.notify.EDataErrors)}.
	 */
	//@Test
	public void testXmlNotificationMessageEDataErrors()
	{
		fail("Not yet implemented");
	}

}
