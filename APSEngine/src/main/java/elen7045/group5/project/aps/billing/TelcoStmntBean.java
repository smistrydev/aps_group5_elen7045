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

	public String getTelephoneNumber()
	{
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber)
	{
		this.telephoneNumber = telephoneNumber;
	}

	public int getTotalNumberOfCalls()
	{
		return totalNumberOfCalls;
	}

	public void setTotalNumberOfCalls(int totalNumberOfCalls)
	{
		this.totalNumberOfCalls = totalNumberOfCalls;
	}

	public int getTotalCallDurationSeconds()
	{
		return totalCallDurationSeconds;
	}

	public void setTotalCallDurationSeconds(int totalCallDurationSeconds)
	{
		this.totalCallDurationSeconds = totalCallDurationSeconds;
	}

	public float getServiceCharges()
	{
		return serviceCharges;
	}

	public void setServiceCharges(float serviceCharges)
	{
		this.serviceCharges = serviceCharges;
	}

	public float getCallCharges()
	{
		return callCharges;
	}

	public void setCallCharges(float callCharges)
	{
		this.callCharges = callCharges;
	}

}