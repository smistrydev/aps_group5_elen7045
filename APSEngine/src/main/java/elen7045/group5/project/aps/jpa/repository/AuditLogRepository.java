/**
 * 
 */
package elen7045.group5.project.aps.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import elen7045.group5.project.aps.jpa.model.Account;

public interface AuditLogRepository extends JpaRepository<Account, Integer>
{

}