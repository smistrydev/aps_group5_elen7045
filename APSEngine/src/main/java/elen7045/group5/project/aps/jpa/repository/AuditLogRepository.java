/**
 * 
 */
package elen7045.group5.project.aps.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import elen7045.group5.project.aps.jpa.model.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Integer>
{

}