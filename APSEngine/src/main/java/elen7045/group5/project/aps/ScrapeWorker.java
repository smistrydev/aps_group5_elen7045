package elen7045.group5.project.aps;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.jpa.model.Account;
import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.service.LoadManager;
import elen7045.group5.project.aps.service.Scheduler;

/**
 * Worker is responsible for checking if a scheduled time has been reached and if
 * so then it will kick off a number of {@link ScrapeCustomerWorker} threads to perform
 * the scrape session for all customer accounts linked to the billing company. The size
 * of this pool is dictated by the 
 */
@Component
public class ScrapeWorker implements Runnable
{
	private BillingCompany				billingCompany;
	private AccountPresentationEngine	parentEngine;
	private Logger						logger	= LoggerFactory.getLogger("APS");
	private Scheduler					scheduler;
	private LoadManager					loadManager;
	private List<Account> 				accountPool;

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
		this.scheduler = new Scheduler();
		this.loadManager = new LoadManager();
		this.accountPool = new ArrayList<Account>();
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		while (true)
		{
			Thread t = null;
			ScrapeCustomerWorker custWorkerThread = null;
			logger.info("ScrapeWorker is running....");
			if (scheduler.isScrapeAllowed(billingCompany))
			{
				//set account pool for this iteration
				accountPool = this.billingCompany.getAccounts();
				int threadCnt = loadManager.getMaximumConcurrentUsers(billingCompany);
				if(threadCnt != 0)
				{
					if(threadCnt > accountPool.size())
					{
						threadCnt = accountPool.size(); //don't create unnecessary threads
					}
					
					for(int r = 0; r < threadCnt; r++)
					{
						custWorkerThread = new ScrapeCustomerWorker(this, billingCompany.getUrl(), billingCompany.getProviderType(), 
																		billingCompany.getRetryCount(), billingCompany.getRetryIntervalMinutes());
						t = new Thread(custWorkerThread);
						t.start();
					}
				}			
			}
			
			try
			{
				Thread.sleep(30 * 60 * 1000); //sleep for 30 mins, perhaps this should be configurable?
			}
			catch (InterruptedException ie)
			{
			}

			//TODO: this is to be removed, want to test the iteration
			parentEngine.shutdown();
		}
	}
	
	/**
	 * This method will return one account from within the remaining pool of
	 * accounts
	 * @return Returns an available account, null if no more are available
	 */
	public synchronized Account getAccountFromPool()
	{
		if(accountPool.size() >= 1)
		{
			return accountPool.remove(0);
		}
		else
		{
			return null;
		}
	}

	/**
	 * This method will add the account back to the pool. This will be called
	 * by the {@link ScrapeCustomerWorker} thread if there was a problem with
	 * performing the scrape
	 * @param accountPool
	 */
	public synchronized void setAccountPool(List<Account> accountPool)
	{
		this.accountPool = accountPool;
	}
	
	/**
	 * This method allows the caller to set a new list of billing accounts
	 * @param newList
	 */
	public synchronized void setBillingCompanyAccounts(List<Account> newList)
	{
		this.billingCompany.setAccounts(newList);
	}
}
