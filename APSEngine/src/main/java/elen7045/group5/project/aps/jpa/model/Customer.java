package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
public class Customer implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "customer_id")
	private int					customerId;

	@Column(name = "email_address")
	private String				emailAddress;

	private String				name;

	private String				password;

	private String				surname;

	// bi-directional many-to-one association to Account
	@OneToMany(mappedBy = "customer")
	private List<Account>		accounts;

	// bi-directional many-to-one association to AuditLog
	@OneToMany(mappedBy = "customer")
	private List<AuditLog>		auditLogs;

	public Customer()
	{
	}

	public int getCustomerId()
	{
		return this.customerId;
	}

	public void setCustomerId(int customerId)
	{
		this.customerId = customerId;
	}

	public String getEmailAddress()
	{
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getSurname()
	{
		return this.surname;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public List<Account> getAccounts()
	{
		return this.accounts;
	}

	public void setAccounts(List<Account> accounts)
	{
		this.accounts = accounts;
	}

	public Account addAccount(Account account)
	{
		getAccounts().add(account);
		account.setCustomer(this);

		return account;
	}

	public Account removeAccount(Account account)
	{
		getAccounts().remove(account);
		account.setCustomer(null);

		return account;
	}

	public List<AuditLog> getAuditLogs()
	{
		return this.auditLogs;
	}

	public void setAuditLogs(List<AuditLog> auditLogs)
	{
		this.auditLogs = auditLogs;
	}

	public AuditLog addAuditLog(AuditLog auditLog)
	{
		getAuditLogs().add(auditLog);
		auditLog.setCustomer(this);

		return auditLog;
	}

	public AuditLog removeAuditLog(AuditLog auditLog)
	{
		getAuditLogs().remove(auditLog);
		auditLog.setCustomer(null);

		return auditLog;
	}

}