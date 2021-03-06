package elen7045.group5.project.wsa;

import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import elen7045.group5.project.aps.config.APSAuditLog;
import elen7045.group5.project.aps.encrypt.service.SecureAPSEncryptor;
import elen7045.group5.project.aps.jpa.model.Account;

/**
 * This is used as an abstraction to a third party website scraper. This allows
 * us to treat the external application as a pluggable module in the application
 * that can be swapped out with another if need be without affecting the rest of
 * the code. The interface defines the operations that can be performed against
 * it.
 */
public class WebsiteScraperGateway
{
	private Logger				logger			= LoggerFactory.getLogger("APS");
	private SecureAPSEncryptor	apsEncryptor	= new SecureAPSEncryptor("apsSalt");

	/**
	 * This method will perform a scrape by logging onto the company contained
	 * in the passed bean using the customer's details and retrieve the
	 * statement information
	 * 
	 * @param companyURL
	 *            - URL of the company to connect to and scrape
	 * @param customerAcc
	 * 			- Account details to use when logging onto the company's site
	 * @return Returns the XML string containing the scraped data or any errors
	 *         encountered
	 */
	@APSAuditLog
	public String performScrape(String companyURL, Account customerAcc)
	{
		InputStream is = null;
		logger.info("Scrape called for company " + companyURL);

		// The password is decrypted here.
		String encrptedPassword = customerAcc.getCustomerLoginPassword();
		String plainPassword = apsEncryptor.decrypt(encrptedPassword);
		customerAcc.setCustomerLoginPassword(plainPassword);

		
		// Below code is simply immulating as if a real 3rd party wedsite scrapper was called and responded.
		try
		{
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
		catch (Exception e) // covers IOException & JAXBException
		{
			logger.error("Error performing scrape: " + e.toString());
		}
		finally
		{
			//the plain text password gets discarded.
			plainPassword = null;
			customerAcc.setCustomerLoginPassword(encrptedPassword);
		}

		return null;
	}
}
