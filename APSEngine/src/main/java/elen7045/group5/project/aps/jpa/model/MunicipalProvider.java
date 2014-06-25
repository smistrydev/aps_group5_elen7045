package elen7045.group5.project.aps.jpa.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;

/**
 * The persistent class for the municipal_provider database table.
 * 
 */
@Entity
@Table(name = "municipal_provider")
@NamedQuery(name = "MunicipalProvider.findAll", query = "SELECT m FROM MunicipalProvider m")
public class MunicipalProvider implements Serializable
{
	private static final long	serialVersionUID	= 1L;

	@Id
	@Column(name = "municipality_id")
	private int					municipalityId;

	@Column(name = "electricity_charges")
	private BigDecimal			electricityCharges;

	@Column(name = "electricity_used")
	private BigDecimal			electricityUsed;

	@Column(name = "gas_charges")
	private BigDecimal			gasCharges;

	@Column(name = "gas_used")
	private BigDecimal			gasUsed;

	@Column(name = "instalment_notice")
	private String				instalmentNotice;

	@Column(name = "refuse_charges")
	private BigDecimal			refuseCharges;

	@Column(name = "sewerage_charges")
	private BigDecimal			sewerageCharges;

	@Column(name = "water_charges")
	private BigDecimal			waterCharges;

	@Column(name = "water_used")
	private BigDecimal			waterUsed;

	// bi-directional many-to-one association to Statement
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "statement_id")
	private Statement			statement;

	public MunicipalProvider()
	{
	}

	public int getMunicipalityId()
	{
		return this.municipalityId;
	}

	public void setMunicipalityId(int municipalityId)
	{
		this.municipalityId = municipalityId;
	}

	public BigDecimal getElectricityCharges()
	{
		return this.electricityCharges;
	}

	public void setElectricityCharges(BigDecimal electricityCharges)
	{
		this.electricityCharges = electricityCharges;
	}

	public BigDecimal getElectricityUsed()
	{
		return this.electricityUsed;
	}

	public void setElectricityUsed(BigDecimal electricityUsed)
	{
		this.electricityUsed = electricityUsed;
	}

	public BigDecimal getGasCharges()
	{
		return this.gasCharges;
	}

	public void setGasCharges(BigDecimal gasCharges)
	{
		this.gasCharges = gasCharges;
	}

	public BigDecimal getGasUsed()
	{
		return this.gasUsed;
	}

	public void setGasUsed(BigDecimal gasUsed)
	{
		this.gasUsed = gasUsed;
	}

	public String getInstalmentNotice()
	{
		return this.instalmentNotice;
	}

	public void setInstalmentNotice(String instalmentNotice)
	{
		this.instalmentNotice = instalmentNotice;
	}

	public BigDecimal getRefuseCharges()
	{
		return this.refuseCharges;
	}

	public void setRefuseCharges(BigDecimal refuseCharges)
	{
		this.refuseCharges = refuseCharges;
	}

	public BigDecimal getSewerageCharges()
	{
		return this.sewerageCharges;
	}

	public void setSewerageCharges(BigDecimal sewerageCharges)
	{
		this.sewerageCharges = sewerageCharges;
	}

	public BigDecimal getWaterCharges()
	{
		return this.waterCharges;
	}

	public void setWaterCharges(BigDecimal waterCharges)
	{
		this.waterCharges = waterCharges;
	}

	public BigDecimal getWaterUsed()
	{
		return this.waterUsed;
	}

	public void setWaterUsed(BigDecimal waterUsed)
	{
		this.waterUsed = waterUsed;
	}

	public Statement getStatement()
	{
		return this.statement;
	}

	public void setStatement(Statement statement)
	{
		this.statement = statement;
	}

}