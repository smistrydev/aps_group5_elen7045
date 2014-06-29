package elen7045.group5.project.aps.validation;

import java.util.ArrayList;
import java.util.List;

import elen7045.group5.project.notify.EDataErrors;
import elen7045.group5.project.wsa.ScrapeSession;

/**
 * This is the parent class for all Validators being used in the application
 */
public abstract class Validator
{
	private EValidatorTypes	model	= null;

	/**
	 * Constructor creates the validator for a specific type
	 * @param model
	 */
	public Validator(EValidatorTypes model)
	{
		this.model = model;
	}
	
	/**
	 * Implementations of this method will validate data specific to the type of
	 * statement that was scraped.
	 * @return Returns a list of errors that exist within the application, an empty list if
	 * there were none
	 */
	protected abstract List<ValidationErrorBean> performCaseSpecificValidation(ScrapeSession scrape);	

	/**
	 * Returns the model that was set for this validator
	 * @return
	 */
	public EValidatorTypes getModel()
	{
		return model;
	}
	
	/**
	 * Performs a validation on the scrape data passed
	 * @param scrape - Scrape data obtained from the billing company site
	 * @return Returns a list of errors contained in the scrape data, an empty list if there were
	 * none.
	 */
	public List<ValidationErrorBean> performValidation(ScrapeSession scrape)
	{
		int statementNumber = 0;
		float openingBalance = 0.0F, 
				closingBalance = 0.0F, 
				newCharges = 0.0F, 
				discount = 0.0F, 
				deductions = 0.0F, 
				totalDue = 0.0F, 
				paymentsRecieved = 0.0F;

		String accountHolderName = null,
				accountNumber = null,
				statementMonth = null, 
				statementDate = null, 
				dueDate = null;

		// run through all the data pairs and if you get an exception
		// add the error code to it
		List<ValidationErrorBean> validList = new ArrayList<ValidationErrorBean>();
		List<ValidationErrorBean> typeSpecificValidList = new ArrayList<ValidationErrorBean>();
		
		List<ScrapeSession.Datapair> dataPairList = scrape.getDatapair();
		for (ScrapeSession.Datapair dataPair : dataPairList)
		{
			if (dataPair.getText().equals("Account Number"))
			{
				// No test relates to this field
			}

			if (dataPair.getText().equals("Total due"))
			{
				totalDue = Integer.parseInt(dataPair.getValue());
				if (totalDue < 0)
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}

			if (dataPair.getText().equals("Deductions"))
			{
				deductions = Integer.parseInt(dataPair.getValue());
				if (deductions < 0)
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}

			if (dataPair.getText().equals("New charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges < 0)
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
				// No test relates to this field
			}

			if (dataPair.getText().equals("Payment recieved"))
			{
				paymentsRecieved = Integer.parseInt(dataPair.getValue());
				if (paymentsRecieved < 0)
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}

			if (dataPair.getText().equals("Discount"))
			{
				discount = Integer.parseInt(dataPair.getValue());
				if (discount < 0)
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}

			if (dataPair.getText().equals("Opening balance"))
			{
				try
				{
					openingBalance = Integer.parseInt(dataPair.getValue());
				}
				catch (Exception e)
				{
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
				}
			}

			if (dataPair.getText().equals("Closing balance"))
			{
				try
				{
					closingBalance = Integer.parseInt(dataPair.getValue());
				}
				catch (Exception e)
				{
					validList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
				}
			}

			float actualTotal = openingBalance + paymentsRecieved 
								- newCharges + discount + deductions;
			if (totalDue != actualTotal)
			{
				validList.add(new ValidationErrorBean(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION, dataPair.getText()));
			}

			if (openingBalance - totalDue != closingBalance)
			{
				validList.add(new ValidationErrorBean(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION, dataPair.getText()));
			}
		}

		typeSpecificValidList = performCaseSpecificValidation(scrape);  // Calls
																			// Enums
																			// to
																			// perform
																			// account
																			// specific
																			// error
																			// checks
		validList.addAll(typeSpecificValidList); // Adds the errors of the
													// account specific check to
													// the main list of errors.
		return validList;
	}
}