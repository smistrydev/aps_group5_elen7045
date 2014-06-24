package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.TelcoServiceProvider;

public interface TelcoServiceProviderService
{

	public TelcoServiceProvider create(TelcoServiceProvider created);

	public TelcoServiceProvider delete(int id) throws NotFoundException;

	public List<TelcoServiceProvider> findAll();

	public TelcoServiceProvider findById(Integer id);

	public TelcoServiceProvider findByEmailAddres(String emailAddress);

	public TelcoServiceProvider update(TelcoServiceProvider updated) throws NotFoundException;
}
