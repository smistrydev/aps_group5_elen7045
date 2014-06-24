package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the maintance_window database table.
 * 
 */
@Entity
@Table(name="maintance_window")
@NamedQuery(name="MaintanceWindow.findAll", query="SELECT m FROM MaintanceWindow m")
public class MaintanceWindow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="maintance_id")
	private int maintanceId;

	private String day;

	private String hour;

	private String minute;

	private String month;

	@Column(name="week_number")
	private String weekNumber;

	//bi-directional many-to-one association to BillingCompany
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="billing_company_id")
	private BillingCompany billingCompany;

	public MaintanceWindow() {
	}

	public int getMaintanceId() {
		return this.maintanceId;
	}

	public void setMaintanceId(int maintanceId) {
		this.maintanceId = maintanceId;
	}

	public String getDay() {
		return this.day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return this.hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return this.minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getWeekNumber() {
		return this.weekNumber;
	}

	public void setWeekNumber(String weekNumber) {
		this.weekNumber = weekNumber;
	}

	public BillingCompany getBillingCompany() {
		return this.billingCompany;
	}

	public void setBillingCompany(BillingCompany billingCompany) {
		this.billingCompany = billingCompany;
	}

}