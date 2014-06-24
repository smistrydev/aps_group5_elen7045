package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.MunicipalProvider;

public interface MunicipalProviderService
{

	public MunicipalProvider create(MunicipalProvider created);

	public MunicipalProvider delete(int id) throws NotFoundException;

	public List<MunicipalProvider> findAll();

	public MunicipalProvider findById(Integer id);
	
	public MunicipalProvider findByEmailAddres(String emailAddress);

	public MunicipalProvider update(MunicipalProvider updated) throws NotFoundException;
}
