package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elen7045.group5.project.aps.jpa.model.AuditLog;
import elen7045.group5.project.aps.jpa.model.BillingCompany;
import elen7045.group5.project.aps.jpa.repository.AuditLogRepository;
import elen7045.group5.project.aps.jpa.repository.BillingCompanyRepository;

@Service
public class RepositoryBillingCompanyService implements BillingCompanyService
{

	@Resource
	private AuditLogRepository	repository;

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
		AuditLog deleted = repository.findOne(id);

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
		BillingCompany original = repository.findOne(updated.getAuditLogId());

		if (original == null)
		{
			throw new NotFoundException();
		}

		original.setAcknowledged(updated.getAcknowledged());

		return original;
	}

	public void setBillingCompanyRepository(BillingCompanyRepository repository)
	{
		this.repository = repository;
	}

}
