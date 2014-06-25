package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import elen7045.group5.project.aps.jpa.model.AuditLog;
import elen7045.group5.project.aps.jpa.repository.AuditLogRepository;

@Service
public class RepositoryAuditLogService implements AuditLogService
{

	@Resource
	private AuditLogRepository	repository;

	@Transactional
	@Override
	public AuditLog create(AuditLog created)
	{
		return repository.save(created);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public AuditLog delete(int id) throws NotFoundException
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
	public List<AuditLog> findAll()
	{
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public AuditLog findById(Integer id)
	{
		return repository.findOne(id);
	}

	@Transactional(rollbackFor = NotFoundException.class)
	@Override
	public AuditLog update(AuditLog updated) throws NotFoundException
	{
		AuditLog original = repository.findOne(updated.getAuditLogId());

		if (original == null)
		{
			throw new NotFoundException();
		}

		original.setAcknowledged(updated.getAcknowledged());

		return original;
	}

	public void setAuditLogRepository(AuditLogRepository repository)
	{
		this.repository = repository;
	}

}
