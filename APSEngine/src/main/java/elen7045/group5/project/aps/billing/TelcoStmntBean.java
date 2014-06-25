package elen7045.group5.project.aps.billing;

/**
 * Statement information specific to Telco providers
 */
public class TelcoStmntBean extends StatementBean
{
	private static final long	serialVersionUID	= 122222L;
	private String				telephoneNumber;
	private int					totalNumberOfCalls,
								totalCallDurationSeconds;
	private float				serviceCharges,
								callCharges;

	/**
	 * @return Returns the telephoneNumber
	 */
	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}

	/**
	 * @param instalmentNotice
	 *            - The instalmentNotice to set
	 */
	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	/**
	 * @return Returns the totalNumberOfCalls
	 */
	public int getTotalNumberOfCalls()
	{
		return totalNumberOfCalls;
	}

	/**
	 * @param totalNumberOfCalls
	 *            - The totalNumberOfCalls to set
	 */
	public void setTotalNumberOfCalls(int totalNumberOfCalls)
	{
		this.totalNumberOfCalls = totalNumberOfCalls;
	}

	/**
	 * @return Returns the totalCallDurationSeconds
	 */
	public int getTotalCallDurationSeconds()
	{
		return totalCallDurationSeconds;
	}

	/**
	 * @param totalCallDurationSeconds
	 *            - The totalCallDurationSeconds to set
	 */
	public void setTotalCallDurationSeconds(int totalCallDurationSeconds)
	{
		this.totalCallDurationSeconds = totalCallDurationSeconds;
	}

	/**
	 * @return Returns the serviceCharges
	 */
	public float getServiceCharges()
	{
		return serviceCharges;
	}

	/**
	 * @param serviceCharges
	 *            - The serviceCharges to set
	 */
	public void setServiceCharges(float serviceCharges)
	{
		this.serviceCharges = serviceCharges;
	}

	/**
	 * @return Returns the callCharges
	 */
	public float getCallCharges()
	{
		return callCharges;
	}

	/**
	 * @param callCharges
	 *            - The callCharges to set
	 */
	public void setCallCharges(float callCharges)
	{
		this.callCharges = callCharges;
	}

}