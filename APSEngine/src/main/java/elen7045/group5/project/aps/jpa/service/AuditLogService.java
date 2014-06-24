package elen7045.group5.project.aps.jpa.service;

import java.util.List;

import elen7045.group5.project.aps.jpa.model.AuditLog;

public interface AuditLogService
{

	public AuditLog create(AuditLog created);

	public AuditLog delete(int id) throws NotFoundException;

	public List<AuditLog> findAll();

	public AuditLog findById(Integer id);

	public AuditLog update(AuditLog updated) throws NotFoundException;
}
