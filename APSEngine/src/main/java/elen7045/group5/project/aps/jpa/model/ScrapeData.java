package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the scrape_data database table.
 * 
 */
@Entity
@Table(name="scrape_data")
@NamedQuery(name="ScrapeData.findAll", query="SELECT s FROM ScrapeData s")
public class ScrapeData implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="scrape_data_id")
	private int scrapeDataId;

	@Column(name="customer_id")
	private int customerId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="scrape_timestamp")
	private Date scrapeTimestamp;

	@Column(name="status_code")
	private int statusCode;

	@Column(name="xml_result")
	private Object xmlResult;

	//bi-directional many-to-one association to Statement
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="statement_id")
	private Statement statement;

	public ScrapeData() {
	}

	public int getScrapeDataId() {
		return this.scrapeDataId;
	}

	public void setScrapeDataId(int scrapeDataId) {
		this.scrapeDataId = scrapeDataId;
	}

	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Date getScrapeTimestamp() {
		return this.scrapeTimestamp;
	}

	public void setScrapeTimestamp(Date scrapeTimestamp) {
		this.scrapeTimestamp = scrapeTimestamp;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public Object getXmlResult() {
		return this.xmlResult;
	}

	public void setXmlResult(Object xmlResult) {
		this.xmlResult = xmlResult;
	}

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

}