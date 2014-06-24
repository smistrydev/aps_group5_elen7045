package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the account database table.
 * 
 */
@Entity
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="account_id")
	private int accountId;

	@Column(name="account_number")
	private String accountNumber;

	@Column(name="customer_login_name")
	private String customerLoginName;

	@Column(name="customer_login_password")
	private String customerLoginPassword;

	//bi-directional many-to-one association to BillingCompany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="billing_company_id")
	private BillingCompany billingCompany;

	//bi-directional many-to-one association to Customer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_id")
	private Customer customer;

	//bi-directional many-to-one association to Statement
	@OneToMany(mappedBy="account")
	private List<Statement> statements;

	public Account() {
	}

	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerLoginName() {
		return this.customerLoginName;
	}

	public void setCustomerLoginName(String customerLoginName) {
		this.customerLoginName = customerLoginName;
	}

	public String getCustomerLoginPassword() {
		return this.customerLoginPassword;
	}

	public void setCustomerLoginPassword(String customerLoginPassword) {
		this.customerLoginPassword = customerLoginPassword;
	}

	public BillingCompany getBillingCompany() {
		return this.billingCompany;
	}

	public void setBillingCompany(BillingCompany billingCompany) {
		this.billingCompany = billingCompany;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Statement> getStatements() {
		return this.statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	public Statement addStatement(Statement statement) {
		getStatements().add(statement);
		statement.setAccount(this);

		return statement;
	}

	public Statement removeStatement(Statement statement) {
		getStatements().remove(statement);
		statement.setAccount(null);

		return statement;
	}

}