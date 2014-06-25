package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the telco_service_provider database table.
 * 
 */
@Entity
@Table(name="telco_service_provider")
@NamedQuery(name="TelcoServiceProvider.findAll", query="SELECT t FROM TelcoServiceProvider t")
public class TelcoServiceProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="telco_service_provider_id")
	private int telcoServiceProviderId;

	@Column(name="call_charges")
	private BigDecimal callCharges;

	@Column(name="service_charges")
	private BigDecimal serviceCharges;

	@Column(name="telephone_number")
	private String telephoneNumber;

	@Column(name="total_call_duration_seconds")
	private int totalCallDurationSeconds;

	@Column(name="total_number_of_calls")
	private int totalNumberOfCalls;

	//bi-directional many-to-one association to Statement
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="statement_id")
	private Statement statement;

	public TelcoServiceProvider() {
	}

	public int getTelcoServiceProviderId() {
		return this.telcoServiceProviderId;
	}

	public void setTelcoServiceProviderId(int telcoServiceProviderId) {
		this.telcoServiceProviderId = telcoServiceProviderId;
	}

	public BigDecimal getCallCharges() {
		return this.callCharges;
	}

	public void setCallCharges(BigDecimal callCharges) {
		this.callCharges = callCharges;
	}

	public BigDecimal getServiceCharges() {
		return this.serviceCharges;
	}

	public void setServiceCharges(BigDecimal serviceCharges) {
		this.serviceCharges = serviceCharges;
	}

	public String getTelephoneNumber() {
		return this.telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public int getTotalCallDurationSeconds() {
		return this.totalCallDurationSeconds;
	}

	public void setTotalCallDurationSeconds(int totalCallDurationSeconds) {
		this.totalCallDurationSeconds = totalCallDurationSeconds;
	}

	public int getTotalNumberOfCalls() {
		return this.totalNumberOfCalls;
	}

	public void setTotalNumberOfCalls(int totalNumberOfCalls) {
		this.totalNumberOfCalls = totalNumberOfCalls;
	}

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

}