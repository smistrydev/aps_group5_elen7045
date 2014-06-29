package elen7045.group5.project.wsa;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.model.Customer;

/**
 * This is used as an abstraction to a third party website scraper. This allows
 * us to treat the external application as a pluggable module in the application
 * that can be swapped out with another if need be without affecting the rest of
 * the code. The interface defines the operations that can be performed against
 * it.
 */
public class WebsiteScraperGateway
{

	/**
	 * This method will perform a scrape by logging onto the company contained
	 * in the passed bean using the customer's details and retrieve the
	 * statement information
	 * 
	 * @param billingAcc
	 *            - Bean containing all the required data to perform a scrape
	 * @return Returns the XML string containing the scraped data or any errors
	 *         encountered
	 * @throws IOException
	 * @throws JAXBException
	 */
	public String performScrape(BillingCompany billingCompany, Customer customer)
			throws IOException, JAXBException
	{

		String companyURL = billingCompany.getUrl();

		InputStream is = null;

		if (companyURL.equalsIgnoreCase("www.edgars.co.za"))
		{
			is = ClassLoader.getSystemClassLoader()
					.getResource("elen7045/group5/project/wsa/xml/credit_card/CreditCard.xml")
					.openStream();

		}
		else if (companyURL.equalsIgnoreCase("www.cityofjoburg.co.za"))
		{
			is = ClassLoader.getSystemClassLoader()
					.getResource("elen7045/group5/project/wsa/xml/credit_card/CreditCard.xml")
					.openStream();

		}
		else if (companyURL.equalsIgnoreCase("www.telkom.co.za"))
		{
			is = ClassLoader.getSystemClassLoader()
					.getResource("elen7045/group5/project/wsa/xml/credit_card/CreditCard.xml")
					.openStream();

		}

		ScrapeSession scrapeSession = ScrapeSessionXMLUtil.fromXML(is);

		return ScrapeSessionXMLUtil.toXML(scrapeSession);
	}
}
