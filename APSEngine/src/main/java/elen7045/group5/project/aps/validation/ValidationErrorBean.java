package elen7045.group5.project.aps.validation;

import java.io.Serializable;

import elen7045.group5.project.notify.EDataErrors;

/**
 * Bean is populated by the Validator classes and will contain the validation
 * error as well as the field in the scrape data that contained the error
 * @author Robert Botes
 */
public class ValidationErrorBean implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	private EDataErrors errorCode;
	private String scrapeErrorField;
	
	/**
	 * Constructor creates the object with an error and where the error occurred
	 * @param error
	 * @param errorField
	 */
	public ValidationErrorBean(EDataErrors error, String errorField)
	{
		this.errorCode = error;
		this.scrapeErrorField = errorField;
	}	
	
	/**
	 * Code representing the error encountered
	 * @return
	 */
	public EDataErrors getErrorCode()
	{
		return errorCode;
	}
	
	/**
	 * This is the field in the scrape session that contains the error so
	 * we can identify what to fix
	 * @return
	 */
	public String getScrapeErrorField()
	{
		return scrapeErrorField;
	}
}
