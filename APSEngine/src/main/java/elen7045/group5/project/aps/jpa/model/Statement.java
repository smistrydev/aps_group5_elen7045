package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the statement database table.
 * 
 */
@Entity
@NamedQuery(name="Statement.findAll", query="SELECT s FROM Statement s")
public class Statement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="statement_id")
	private int statementId;

	@Column(name="account_holder_name")
	private String accountHolderName;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="closing_balance")
	private BigDecimal closingBalance;

	private BigDecimal deductions;

	private BigDecimal discount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="due_date")
	private Date dueDate;

	@Column(name="new_charges")
	private BigDecimal newCharges;

	@Column(name="opening_balance")
	private BigDecimal openingBalance;

	@Column(name="payment_recieved")
	private BigDecimal paymentRecieved;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="statement_date")
	private Date statementDate;

	@Column(name="statement_month")
	private int statementMonth;

	@Column(name="statement_number")
	private int statementNumber;

	@Column(name="total_due")
	private BigDecimal totalDue;

	@Column(name="vat_amount")
	private BigDecimal vatAmount;

	//bi-directional many-to-one association to CreditCardProvider
	@OneToMany(mappedBy="statement")
	private List<CreditCardProvider> creditCardProviders;

	//bi-directional many-to-one association to MunicipalProvider
	@OneToMany(mappedBy="statement")
	private List<MunicipalProvider> municipalProviders;

	//bi-directional many-to-one association to ScrapeData
	@OneToMany(mappedBy="statement")
	private List<ScrapeData> scrapeData;

	//bi-directional many-to-one association to Account
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id")
	private Account account;

	//bi-directional many-to-one association to StatementProvider
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="statement_provider_id")
	private StatementProvider statementProvider;

	//bi-directional many-to-one association to TelcoServiceProvider
	@OneToMany(mappedBy="statement")
	private List<TelcoServiceProvider> telcoServiceProviders;

	public Statement() {
	}

	public int getStatementId() {
		return this.statementId;
	}

	public void setStatementId(int statementId) {
		this.statementId = statementId;
	}

	public String getAccountHolderName() {
		return this.accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getClosingBalance() {
		return this.closingBalance;
	}

	public void setClosingBalance(BigDecimal closingBalance) {
		this.closingBalance = closingBalance;
	}

	public BigDecimal getDeductions() {
		return this.deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}

	public BigDecimal getDiscount() {
		return this.discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public BigDecimal getNewCharges() {
		return this.newCharges;
	}

	public void setNewCharges(BigDecimal newCharges) {
		this.newCharges = newCharges;
	}

	public BigDecimal getOpeningBalance() {
		return this.openingBalance;
	}

	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	public BigDecimal getPaymentRecieved() {
		return this.paymentRecieved;
	}

	public void setPaymentRecieved(BigDecimal paymentRecieved) {
		this.paymentRecieved = paymentRecieved;
	}

	public Date getStatementDate() {
		return this.statementDate;
	}

	public void setStatementDate(Date statementDate) {
		this.statementDate = statementDate;
	}

	public int getStatementMonth() {
		return this.statementMonth;
	}

	public void setStatementMonth(int statementMonth) {
		this.statementMonth = statementMonth;
	}

	public int getStatementNumber() {
		return this.statementNumber;
	}

	public void setStatementNumber(int statementNumber) {
		this.statementNumber = statementNumber;
	}

	public BigDecimal getTotalDue() {
		return this.totalDue;
	}

	public void setTotalDue(BigDecimal totalDue) {
		this.totalDue = totalDue;
	}

	public BigDecimal getVatAmount() {
		return this.vatAmount;
	}

	public void setVatAmount(BigDecimal vatAmount) {
		this.vatAmount = vatAmount;
	}

	public List<CreditCardProvider> getCreditCardProviders() {
		return this.creditCardProviders;
	}

	public void setCreditCardProviders(List<CreditCardProvider> creditCardProviders) {
		this.creditCardProviders = creditCardProviders;
	}

	public CreditCardProvider addCreditCardProvider(CreditCardProvider creditCardProvider) {
		getCreditCardProviders().add(creditCardProvider);
		creditCardProvider.setStatement(this);

		return creditCardProvider;
	}

	public CreditCardProvider removeCreditCardProvider(CreditCardProvider creditCardProvider) {
		getCreditCardProviders().remove(creditCardProvider);
		creditCardProvider.setStatement(null);

		return creditCardProvider;
	}

	public List<MunicipalProvider> getMunicipalProviders() {
		return this.municipalProviders;
	}

	public void setMunicipalProviders(List<MunicipalProvider> municipalProviders) {
		this.municipalProviders = municipalProviders;
	}

	public MunicipalProvider addMunicipalProvider(MunicipalProvider municipalProvider) {
		getMunicipalProviders().add(municipalProvider);
		municipalProvider.setStatement(this);

		return municipalProvider;
	}

	public MunicipalProvider removeMunicipalProvider(MunicipalProvider municipalProvider) {
		getMunicipalProviders().remove(municipalProvider);
		municipalProvider.setStatement(null);

		return municipalProvider;
	}

	public List<ScrapeData> getScrapeData() {
		return this.scrapeData;
	}

	public void setScrapeData(List<ScrapeData> scrapeData) {
		this.scrapeData = scrapeData;
	}

	public ScrapeData addScrapeData(ScrapeData scrapeData) {
		getScrapeData().add(scrapeData);
		scrapeData.setStatement(this);

		return scrapeData;
	}

	public ScrapeData removeScrapeData(ScrapeData scrapeData) {
		getScrapeData().remove(scrapeData);
		scrapeData.setStatement(null);

		return scrapeData;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public StatementProvider getStatementProvider() {
		return this.statementProvider;
	}

	public void setStatementProvider(StatementProvider statementProvider) {
		this.statementProvider = statementProvider;
	}

	public List<TelcoServiceProvider> getTelcoServiceProviders() {
		return this.telcoServiceProviders;
	}

	public void setTelcoServiceProviders(List<TelcoServiceProvider> telcoServiceProviders) {
		this.telcoServiceProviders = telcoServiceProviders;
	}

	public TelcoServiceProvider addTelcoServiceProvider(TelcoServiceProvider telcoServiceProvider) {
		getTelcoServiceProviders().add(telcoServiceProvider);
		telcoServiceProvider.setStatement(this);

		return telcoServiceProvider;
	}

	public TelcoServiceProvider removeTelcoServiceProvider(TelcoServiceProvider telcoServiceProvider) {
		getTelcoServiceProviders().remove(telcoServiceProvider);
		telcoServiceProvider.setStatement(null);

		return telcoServiceProvider;
	}

}