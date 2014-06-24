package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.StatementProvider;

public interface StatementProviderService
{

	public StatementProvider create(StatementProvider created);

	public StatementProvider delete(int id) throws NotFoundException;

	public List<StatementProvider> findAll();

	public StatementProvider findById(Integer id);

	public StatementProvider findByEmailAddres(String emailAddress);

	public StatementProvider update(StatementProvider updated) throws NotFoundException;
}
