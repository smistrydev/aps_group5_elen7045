/**
 * 
 */
package elen7045.group5.project.aps.wsa.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import elen7045.group5.project.wsa.ScrapeSession;
import elen7045.group5.project.wsa.ScrapeSessionXMLUtil;

/**
 * 
 * @author Sanjay Mistry
 */
public class WSAScrapeTest
{

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

	@Test
	public void testSuccessfulScrapeTelkomStatement() throws IOException, JAXBException
	{
		InputStream is = ClassLoader.getSystemClassLoader()
				.getResource("elen7045/group5/project/wsa/xml/telco/Telco.xml").openStream();

		ScrapeSession scrapeSession = ScrapeSessionXMLUtil.fromXML(is);

		assertNotNull(scrapeSession);
		assertEquals("www.telkom.co.za", scrapeSession.getBaseUrl());

		// Get Given Data: BillingCompany & Customer,

		// Then run test at scheduled time

		// Scrape Data

	}

	@Test
	public void testSuccessfulScrapeCreditCardStatement() throws IOException, JAXBException
	{
		InputStream is = ClassLoader.getSystemClassLoader()
				.getResource("elen7045/group5/project/wsa/xml/credit_card/CreditCard.xml")
				.openStream();

		ScrapeSession scrapeSession = ScrapeSessionXMLUtil.fromXML(is);

		assertNotNull(scrapeSession);
		assertEquals("www.edgars.co.za", scrapeSession.getBaseUrl());

		// Get Given Data: BillingCompany & Customer,

		// Then run test at scheduled time

		// Scrape Data

	}

	@Test
	public void testSuccessfulScrapeMunicipalStatement() throws IOException, JAXBException
	{
		String path = ClassLoader.getSystemClassLoader()
				.getResource("elen7045/group5/project/wsa/xml/municipal/Municipality.xml")
				.getFile();
		InputStream is = ClassLoader.getSystemClassLoader()
				.getResource("elen7045/group5/project/wsa/xml/municipal/Municipality.xml")
				.openStream();

		System.out.println(">>>>" + path);
		
		ScrapeSession scrapeSession = ScrapeSessionXMLUtil.fromXML(is);
		
		is.close();

		assertNotNull(scrapeSession);
		assertEquals("www.cityofjoburg.org.za", scrapeSession.getBaseUrl());

		// Get Given Data: BillingCompany & Customer,

		// Then run test at scheduled time

		// Scrape Data

	}

}
