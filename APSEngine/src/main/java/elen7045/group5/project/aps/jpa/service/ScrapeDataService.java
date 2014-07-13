package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.ScrapeData;
import elen7045.group5.project.wsa.ScrapeSession;

public interface ScrapeDataService
{

	public ScrapeData create(ScrapeSession created);

	public ScrapeData delete(int id) throws NotFoundException;

	public List<ScrapeData> findAll();

	public ScrapeData findById(Integer id);

	public ScrapeData findByEmailAddres(String emailAddress);

	public ScrapeData update(ScrapeData updated) throws NotFoundException;
}
