package elen7045.group5.project.notify;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import elen7045.group5.project.aps.config.ApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
public class ApplicationErrorsBeanTest
{

	ApplicationErrorsBean	app1	= new ApplicationErrorsBean(
											EApplicationErrors.ACTION_REQUIRED_BY_BILLING_WEBSITE);
	ApplicationErrorsBean	app2	= new ApplicationErrorsBean(
											EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
	ApplicationErrorsBean	app3	= new ApplicationErrorsBean(
											EScrapperSchedularErrors.SCHEDUKER_REACHED_MAXIMUM_RETRIES);
	ApplicationErrorsBean	app4	= new ApplicationErrorsBean(
											EUserInterfaceErrors.INVALID_USER_NAME);

	@Test
	public void testApplicationErrorsBeanEApplicationErrors()
	{
		assertEquals(2004, app1.getErrorCode());
		// fail("Not yet implemented");
	}

	//@Test
	public void testApplicationErrorsBeanEDataErrors()
	{
		// fail("Not yet implemented");
		assertEquals(1005, app2.getErrorCode());
	}

	//@Test
	public void testApplicationErrorsBeanEScrapperSchedularErrors()
	{
		// fail("Not yet implemented");
		assertEquals(3002, app3.getErrorCode());
	}

	//@Test
	public void testApplicationErrorsBeanEUserInterfaceErrors()
	{
		// fail("Not yet implemented");
		assertEquals(001, app4.getErrorCode());
	}

	//@Test
	public void testGetErrorCode()
	{
		assertEquals(3002, app3.getErrorCode());
	}

}
