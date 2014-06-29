package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.repository.BillingCompanyRepository;

@Service
public class RepositoryBillingCompanyService implements BillingCompanyService
{

	@Resource
	private BillingCompanyRepository	repository;

	@Transactional
	@Override
	public BillingCompany create(BillingCompany created)
	{
		return repository.save(created);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public BillingCompany delete(int id) throws NotFoundException
	{
		BillingCompany deleted = repository.findOne(id);

		if (deleted == null)
		{
			throw new NotFoundException();
		}

		repository.delete(deleted);

		return deleted;
	}

	@Transactional(readOnly = true)
	@Override
	public List<BillingCompany> findAll()
	{
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public BillingCompany findById(Integer id)
	{
		return repository.findOne(id);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public BillingCompany update(BillingCompany updated) throws NotFoundException
	{
		BillingCompany original = repository.findOne(updated.getBillingCompanyId());

		if (original == null)
		{
			throw new NotFoundException();
		}

		original.setBillingCompanyName(updated.getBillingCompanyName());
		original.setDaysPerCycle(updated.getDaysPerCycle());
		original.setLeadTimeDays(updated.getLeadTimeDays());
		original.setRetryCount(updated.getRetryCount());
		original.setRetryIntervalMinutes(updated.getRetryCount());
		original.setUrl(updated.getUrl());

		return original;
	}

	public void setBillingCompanyRepository(BillingCompanyRepository repository)
	{
		this.repository = repository;
	}

}
