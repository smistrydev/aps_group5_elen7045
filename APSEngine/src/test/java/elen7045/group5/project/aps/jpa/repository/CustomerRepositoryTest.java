package elen7045.group5.project.aps.jpa.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import elen7045.group5.project.aps.jpa.config.ApplicationContext;
import elen7045.group5.project.aps.jpa.model.Customer;
import elen7045.group5.project.aps.jpa.service.CustomerService;

/**
 * 
 * @author Sanjay Mistry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationContext.class })
public class CustomerRepositoryTest
{

	@Autowired
	private CustomerService	service;

	/**
	 * Test method for {@link com.sanjay.test.jpa.model.Notification#toString()}
	 * .
	 */
	@Test
	public void testNotificationGetAll()
	{
		Iterable<Customer> customers = service.findAll();

		assertNotNull(customers);
		assertTrue(customers.iterator().hasNext());

	}

	@Test
	public void testFindCustomerByValidEmaillAddress()
	{

		String testEmail = "test@me.com";
		Customer customer = service.findByEmailAddres(testEmail);
		assertNotNull(customer);
		assertEquals(customer.getEmailAddress(), testEmail);

	}

}
