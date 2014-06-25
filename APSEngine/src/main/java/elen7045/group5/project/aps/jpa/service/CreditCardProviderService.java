package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.CreditCardProvider;

public interface CreditCardProviderService
{

	public CreditCardProvider create(CreditCardProvider created);

	public CreditCardProvider delete(int id) throws NotFoundException;

	public List<CreditCardProvider> findAll();

	public CreditCardProvider findById(Integer id);

	public CreditCardProvider findByEmailAddres(String emailAddress);

	public CreditCardProvider update(CreditCardProvider updated) throws NotFoundException;
}
