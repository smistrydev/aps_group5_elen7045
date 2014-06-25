package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the billing_company database table.
 * 
 */
@Entity
@Table(name = "billing_company")
@NamedQuery(name = "BillingCompany.findAll", query = "SELECT b FROM BillingCompany b")
public class BillingCompany implements Serializable
{
	private static final long		serialVersionUID	= 1L;

	@Id
	@Column(name = "billing_company_id")
	private int						billingCompanyId;

	@Column(name = "billing_company_name")
	private String					billingCompanyName;

	@Column(name = "days_per_cycle")
	private int						daysPerCycle;

	@Column(name = "lead_time_days")
	private int						leadTimeDays;

	@Column(name = "retry_count")
	private int						retryCount;

	@Column(name = "retry_interval_minutes")
	private int						retryIntervalMinutes;

	private String					url;

	// bi-directional many-to-one association to Account
	@OneToMany(mappedBy = "billingCompany")
	private List<Account>			accounts;

	// bi-directional many-to-one association to MaintenanceWindow
	@OneToMany(mappedBy = "billingCompany")
	private List<MaintenanceWindow>	maintenanceWindows;

	public BillingCompany()
	{
	}

	public int getBillingCompanyId()
	{
		return this.billingCompanyId;
	}

	public void setBillingCompanyId(int billingCompanyId)
	{
		this.billingCompanyId = billingCompanyId;
	}

	public String getBillingCompanyName()
	{
		return this.billingCompanyName;
	}

	public void setBillingCompanyName(String billingCompanyName)
	{
		this.billingCompanyName = billingCompanyName;
	}

	public int getDaysPerCycle()
	{
		return this.daysPerCycle;
	}

	public void setDaysPerCycle(int daysPerCycle)
	{
		this.daysPerCycle = daysPerCycle;
	}

	public int getLeadTimeDays()
	{
		return this.leadTimeDays;
	}

	public void setLeadTimeDays(int leadTimeDays)
	{
		this.leadTimeDays = leadTimeDays;
	}

	public int getRetryCount()
	{
		return this.retryCount;
	}

	public void setRetryCount(int retryCount)
	{
		this.retryCount = retryCount;
	}

	public int getRetryIntervalMinutes()
	{
		return this.retryIntervalMinutes;
	}

	public void setRetryIntervalMinutes(int retryIntervalMinutes)
	{
		this.retryIntervalMinutes = retryIntervalMinutes;
	}

	public String getUrl()
	{
		return this.url;
	}

	public void setUrl(String url)
	{
		this.url = url;
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
		account.setBillingCompany(this);

		return account;
	}

	public Account removeAccount(Account account)
	{
		getAccounts().remove(account);
		account.setBillingCompany(null);

		return account;
	}

	public List<MaintenanceWindow> getMaintenanceWindows()
	{
		return this.maintenanceWindows;
	}

	public void setMaintenanceWindows(List<MaintenanceWindow> maintenanceWindows)
	{
		this.maintenanceWindows = maintenanceWindows;
	}

	public MaintenanceWindow addMaintenanceWindow(MaintenanceWindow maintenanceWindow)
	{
		getMaintenanceWindows().add(maintenanceWindow);
		maintenanceWindow.setBillingCompany(this);

		return maintenanceWindow;
	}

	public MaintenanceWindow removeMaintenanceWindow(MaintenanceWindow maintenanceWindow)
	{
		getMaintenanceWindows().remove(maintenanceWindow);
		maintenanceWindow.setBillingCompany(null);

		return maintenanceWindow;
	}

}