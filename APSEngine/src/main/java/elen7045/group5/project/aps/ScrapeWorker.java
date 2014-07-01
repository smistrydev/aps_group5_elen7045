package elen7045.group5.project.aps;

import java.util.List;

import javax.xml.bind.JAXBException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import elen7045.group5.project.aps.jpa.model.Account;
import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.model.MaintenanceWindow;
import elen7045.group5.project.aps.jpa.model.ScrapeData;
import elen7045.group5.project.aps.jpa.service.ScrapeDataService;
import elen7045.group5.project.wsa.ScrapeSession;
import elen7045.group5.project.wsa.ScrapeSessionXMLUtil;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * Worker is responsible for checking if a schedule time has been reached and if
 * so then it will kick off a scrape session for all accounts linked to the
 * billing company
 */
public class ScrapeWorker implements Runnable
{
	private BillingCompany				billingCompany;
	private AccountPresentationEngine	parentEngine;
	private WebsiteScraperGateway		gateway;
	private Logger						logger	= LoggerFactory.getLogger("APS");
	@Autowired
	private ScrapeDataService			scrapeSrvc;

	/**
	 * Worker created for a specific company
	 * 
	 * @param bc
	 * @param engine
	 */
	public ScrapeWorker(BillingCompany bc, AccountPresentationEngine engine)
	{
		this.billingCompany = bc;
		this.parentEngine = engine;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		gateway = new WebsiteScraperGateway();
		while (true)
		{
			logger.info("ScrapeWorker is running....");
			if (noConflictWithMaintenance()) // need to include a load balancing
												// check to throttle scrapes
			{
				ScrapeSession scrapeData = null;
				String resultXml = null;
				List<Account> accountList = this.billingCompany.getAccounts();
				for (Account custAcc : accountList)
				{
					try
					{
						resultXml = gateway.performScrape(this.billingCompany, custAcc);
						scrapeData = ScrapeSessionXMLUtil.fromXML(resultXml);
					}
					catch (JAXBException jbe)
					{
						logger.error("Error trying to parse scraped XML: " + jbe.getMessage());
						ScrapeData sd = new ScrapeData();
						
						scrapeSrvc.create(sd);
					}
				}
			}

			logger.info("go through each one and perform a scrape - perhaps this should also be threaded");
			// String result = gateway.performScrape(null);

			logger.info("parse the returned result into objects via JaxB");

			// validate the info

			// persist the data, persistence object should do the audit as well

			try
			{
				Thread.sleep(10000);
			}
			catch (InterruptedException ie)
			{
			}

			parentEngine.shutdown();
		}
	}

	/**
	 * Method is responsible for validating if we are within a maintenance
	 * period for the billing company we are going to scrape.
	 * 
	 * @return Returns true if there are no conflicts, false otherwise.
	 */
	private boolean noConflictWithMaintenance()
	{
		List<MaintenanceWindow> maintWindowList = billingCompany.getMaintenanceWindows();
		return true;// TODO: implement
	}
}
