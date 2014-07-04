package elen7045.group5.project.aps;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.config.ApplicationContext;
import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.service.BillingCompanyService;

/**
 * This is the main controller for the Account Presentation Engine. It is
 * responsible for managing all scraping operations for the various billing
 * companies. Each scraping operation is created as a separate thread to allow
 * concurrent scraping to occur and not to have errors or delays at one company
 * affect another scrape.
 * 
 * @author Robert Botes
 */
@Component
public class AccountPresentationEngine
{
	private Logger					logger	= LoggerFactory.getLogger("APS");
	private boolean					shutdown;
	@Autowired
	private BillingCompanyService	billingCompanySrvc;
	
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args)
//	{
//		AbstractApplicationContext context = null;
//
//		try
//		{
//			context = new AnnotationConfigApplicationContext(
//					ApplicationContext.class);
//
//			AccountPresentationEngine accountPresentationEngine = context
//					.getBean(AccountPresentationEngine.class);
//			accountPresentationEngine.startApplication();
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		finally
//		{
//			((AbstractApplicationContext) context).close();
//		}
//
//		System.exit(0);
//	}

	/**
	 * Method retrieves the billing companies and instantiates a
	 * {@link ScrapeWorker} for each of the billing companies retrieved
	 */
	void startApplication() throws IOException
	{
		Thread thread = null;
		ScrapeWorker worker = null;

		logger.info("Starting up. Retrieving all the billing companies...");
		List<BillingCompany> companies = billingCompanySrvc.findAll();
		for (BillingCompany bc : companies)
		{
			logger.info("Creating worker for company " + bc.getBillingCompanyName());
			bc.getAccounts(); //lazily loaded so force load
			bc.getMaintenanceWindows();		
			
			worker = new ScrapeWorker(bc, this);
			thread = new Thread(worker);
			thread.setDaemon(false);
			thread.start();
		}
		
		while(!shutdown)
		{
			try
			{
				Thread.sleep(5000);
			}
			catch(InterruptedException ie)
			{
			}
		}		
	}

	/**
	 * Called by one of the Workers, indicates that the engine should shut down
	 */
	synchronized void shutdown()
	{
		this.shutdown = true;
		logger.info("Shutting down... Bye!");
	}
}