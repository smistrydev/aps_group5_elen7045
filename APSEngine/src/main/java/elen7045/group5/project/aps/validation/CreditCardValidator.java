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
	protected List<EDataErrors> performCaseSpecificValidation(ScrapeSession scrape)
	{
		List<EDataErrors> creditCardValidList = new ArrayList<EDataErrors>();
		List<ScrapeSession.Datapair> dataPairList = scrape.getDatapair();

		for (ScrapeSession.Datapair dataPair : dataPairList)
		{
			if (dataPair.getText().equals("Minimum amount due"))
			{
				minimumAmountDue = Integer.parseInt(dataPair.getValue());
				if (minimumAmountDue < 0)
					creditCardValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
			}

			if (dataPair.getText().equals("New charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges < 0.0)
					creditCardValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
			}

			if (minimumAmountDue != newCharges)
				creditCardValidList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION);
		}

		return creditCardValidList;
	}
}