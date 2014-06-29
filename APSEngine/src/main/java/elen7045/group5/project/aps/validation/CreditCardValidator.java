package elen7045.group5.project.aps.validation;

import java.util.ArrayList;
import java.util.List;

import elen7045.group5.project.notify.EDataErrors;
import elen7045.group5.project.wsa.ScrapeSession;

/**
 * Credit card specific validation
 */
public class CreditCardValidator extends Validator
{
	private float	minimumAmountDue,
					newCharges;

	CreditCardValidator()
	{
		super(EValidatorTypes.CreditCard);
	}

	/**
	 * @see elen7045.group5.project.aps.validator.Validator#performCaseSpecificValidation(elen7045.group5.project.wsa.ScrapeSession)
	 */
	protected List<ValidationErrorBean> performCaseSpecificValidation(ScrapeSession scrape)
	{
		List<ValidationErrorBean> creditCardValidList = new ArrayList<ValidationErrorBean>();
		List<ScrapeSession.Datapair> dataPairList = scrape.getDatapair();

		for (ScrapeSession.Datapair dataPair : dataPairList)
		{
			if (dataPair.getText().equals("Minimum amount due"))
			{
				minimumAmountDue = Integer.parseInt(dataPair.getValue());
				if (minimumAmountDue < 0)
					creditCardValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}

			if (dataPair.getText().equals("New charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges < 0.0)
					creditCardValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}

			if (minimumAmountDue != newCharges)
				creditCardValidList.add(new ValidationErrorBean(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION, dataPair.getText()));
		}

		return creditCardValidList;
	}
}