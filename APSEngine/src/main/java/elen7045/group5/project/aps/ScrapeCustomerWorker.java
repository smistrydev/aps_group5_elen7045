package elen7045.group5.project.aps;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.jpa.model.Account;
import elen7045.group5.project.aps.jpa.model.EStatementProvider;
import elen7045.group5.project.aps.jpa.service.ScrapeDataService;
import elen7045.group5.project.aps.validation.ValidationErrorBean;
import elen7045.group5.project.aps.validation.Validator;
import elen7045.group5.project.aps.validation.ValidatorFactory;
import elen7045.group5.project.wsa.ScrapeSession;
import elen7045.group5.project.wsa.ScrapeSessionXMLUtil;
import elen7045.group5.project.wsa.WebsiteScraperGateway;

/**
 * This thread is managed by the {@link ScrapeWorker} and interfaces with the
 * {@link WebsiteScraperGateway} in terms of getting a scrape performed.
 */
@Component
public class ScrapeCustomerWorker implements Runnable
{
	private Logger					logger	= LoggerFactory.getLogger("APS");
	private ScrapeWorker			parent;
	private String					billingURL;
	private EStatementProvider		providerType;
	private int						noOfRetries, errorCnt, retryIntervalMin;
	private WebsiteScraperGateway	gateway;
	private ScrapeSession			scrapeData	= null;
	private String					resultXml	= null;
	@Autowired
	private ScrapeDataService			scrapeSrvc;

	/**
	 * Constructor where we link back to the parent thread that spawned this one
	 * @param workerParent
	 * @param billingCompanyURL
	 * @param retryCnt
	 * @param retryInterval
	 */
	public ScrapeCustomerWorker(ScrapeWorker workerParent, String billingCompanyURL, EStatementProvider provider, int retryCnt, int retryInterval)
	{
		this.parent = workerParent;
		this.gateway = new WebsiteScraperGateway();
		this.billingURL = billingCompanyURL;
		this.providerType = provider;
		this.noOfRetries = retryCnt;
		this.retryIntervalMin = retryInterval;
	}

	/**
	 * @see java.lang.Runnable#run()
	 */
	public void run()
	{
		while(errorCnt <= noOfRetries)
		{
			Account account = parent.getAccountFromPool();
			try
			{
				if (account != null)
				{
					resultXml = gateway.performScrape(billingURL, account);
					scrapeData = ScrapeSessionXMLUtil.fromXML(resultXml);
					Validator validator = ValidatorFactory.getValidator(providerType);
					List<ValidationErrorBean> valErrors = validator.performValidation(scrapeData);
					writeAudit(valErrors);					
					scrapeSrvc.create(scrapeData);
				}
				
				break;				
			}
			catch(Exception e)
			{
				logger.error("Exception on account ID " + account.getAccountId() + ", details=" + e.getMessage());
				errorCnt++;
				try
				{
					Thread.sleep(retryIntervalMin * 60 * 1000);
				}
				catch(InterruptedException ie)
				{
				}
			}
		}
	}
	
	/**
	 * Writes an audit of the data retrieved
	 * @param errors
	 */
	private void writeAudit(List<ValidationErrorBean> errors)
	{
		//TODO: if list passed is not empty, log error reasons, otherwise log ok
	}

}
