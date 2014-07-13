package elen7045.group5.project.scrapedata.audit.service;

import elen7045.group5.project.aps.jpa.service.ScrapeDataService;
import elen7045.group5.project.wsa.ScrapeSession;

public class ScrapeDataAudit{
	
	private ScrapeDataService  scrapeDataService;
	private ScrapeSession scrapeData;
	public ScrapeDataAudit( ScrapeSession scrapeData)
	{
		this.scrapeData = scrapeData;
	}
	
	public void createAuditTrail ()
	{
		scrapeDataService.create(scrapeData);
	}
	

}
