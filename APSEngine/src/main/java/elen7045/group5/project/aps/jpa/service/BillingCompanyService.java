package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.BillingCompany;

public interface BillingCompanyService
{

	public BillingCompany create(BillingCompany created);

	public BillingCompany delete(int id) throws NotFoundException;

	public List<BillingCompany> findAll();

	public BillingCompany findById(Integer id);

	public BillingCompany update(BillingCompany updated) throws NotFoundException;
}
