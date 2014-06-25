package elen7045.group5.project.aps.billing;

/**
 * Statement information specific to Municipalities
 */
public class MunicipalityStmntBean extends StatementBean
{
	private static final long	serialVersionUID	= 122222L;
	private String				instalmentNotice;
	private float				electricityUsed,
								electricityCharges,
								gasUsed,
								gasCharges,
								waterUsed,
								waterCharges,
								sewerageCharges,
								refuseCharges;

	/**
	 * @return Returns the instalmentNotice
	 */
	public String getInstalmentNotice()
	{
		return instalmentNotice;
	}

	/**
	 * @param instalmentNotice
	 *            - The instalmentNotice to set
	 */
	public void setInstalmentNotice(String instalmentNotice)
	{
		this.instalmentNotice = instalmentNotice;
	}

	/**
	 * @return Returns the electricityUsed
	 */
	public float getElectricityUsed()
	{
		return electricityUsed;
	}

	/**
	 * @param electricityUsed
	 *            - The electricityUsed to set
	 */
	public void setElectricityUsed(float electricityUsed)
	{
		this.electricityUsed = electricityUsed;
	}

	/**
	 * @return Returns the electricityCharges
	 */
	public float getElectricityCharges()
	{
		return electricityCharges;
	}

	/**
	 * @param electricityCharges
	 *            - The electricityCharges to set
	 */
	public void setElectricityCharges(float electricityCharges)
	{
		this.electricityCharges = electricityCharges;
	}

	/**
	 * @return Returns the gasUsed
	 */
	public float getGasUsed()
	{
		return gasUsed;
	}

	/**
	 * @param gasUsed
	 *            - The gasUsed to set
	 */
	public void setGasUsed(float gasUsed)
	{
		this.gasUsed = gasUsed;
	}

	/**
	 * @return Returns the gasCharges
	 */
	public float getGasCharges()
	{
		return gasCharges;
	}

	/**
	 * @param gasCharges
	 *            - The gasCharges to set
	 */
	public void setGasCharges(float gasCharges)
	{
		this.gasCharges = gasCharges;
	}

	/**
	 * @return Returns the waterUsed
	 */
	public float getWaterUsed()
	{
		return waterUsed;
	}

	/**
	 * @param waterUsed
	 *            - The waterUsed to set
	 */
	public void setWaterUsed(float waterUsed)
	{
		this.waterUsed = waterUsed;
	}

	/**
	 * @return Returns the waterCharges
	 */
	public float getWaterCharges()
	{
		return waterCharges;
	}

	/**
	 * @param waterCharges
	 *            - The waterCharges to set
	 */
	public void setWaterCharges(float waterCharges)
	{
		this.waterCharges = waterCharges;
	}

	/**
	 * @return Returns the sewerageCharges
	 */
	public float getSewerageCharges()
	{
		return sewerageCharges;
	}

	/**
	 * @param sewerageCharges
	 *            - The sewerageCharges to set
	 */
	public void setSewerageCharges(float sewerageCharges)
	{
		this.sewerageCharges = sewerageCharges;
	}

	/**
	 * @return Returns the refuseCharges
	 */
	public float getRefuseCharges()
	{
		return refuseCharges;
	}

	/**
	 * @param refuseCharges
	 *            - The refuseCharges to set
	 */
	public void setRefuseCharges(float refuseCharges)
	{
		this.refuseCharges = refuseCharges;
	}
}