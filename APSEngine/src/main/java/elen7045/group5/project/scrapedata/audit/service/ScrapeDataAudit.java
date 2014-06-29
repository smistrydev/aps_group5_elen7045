package elen7045.group5.project.scrapedata.audit.service;

import elen7045.group5.project.aps.jpa.model.ScrapeData;
import elen7045.group5.project.aps.jpa.service.ScrapeDataService;

public class ScrapeDataAudit{
	
	private ScrapeDataService  scrapeDataService;
	private ScrapeData scrapeData;
	public ScrapeDataAudit( ScrapeData scrapeData)
	{
		this.scrapeData = scrapeData;
	}
	
	public void createAuditTrail ()
	{
		scrapeDataService.create(scrapeData);
	}
	

}
