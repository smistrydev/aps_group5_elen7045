package elen7045.group5.project.aps.validation;

import java.util.ArrayList;
import java.util.List;

import elen7045.group5.project.notify.EDataErrors;
import elen7045.group5.project.wsa.ScrapeSession;

/**
 * Telecommunications specific validation
 */
public class TelcoValidator extends Validator
{
	/**
	 * Default constructor
	 */
	public TelcoValidator()
	{
		super(EValidatorTypes.Municiple);
	}

	/**
	 * @see elen7045.group5.project.aps.validator.Validator#performCaseSpecificValidation(elen7045.group5.project.wsa.ScrapeSession)
	 */
	protected List<EDataErrors> performCaseSpecificValidation(ScrapeSession scrapeData)
	{
		List<EDataErrors> telcoValidList = new ArrayList<EDataErrors>();
		List<ScrapeSession.Datapair> dataPairList = scrapeData.getDatapair();

		float serviceCharges = 0.0F, 
				callCharges = 0.0F, 
				newCharges = 0.0F;

		for (ScrapeSession.Datapair dataPair : dataPairList)
		{
			if (dataPair.getText().equals("Service charges"))
			{
				serviceCharges = Integer.parseInt(dataPair.getValue());
				if (serviceCharges < 0)
					telcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
			}

			if (dataPair.getText().equals("Call charges"))
			{
				callCharges = Integer.parseInt(dataPair.getValue());
				if (callCharges < 0)
					telcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
			}

			if (dataPair.getText().equals("New Charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges < 0)
					telcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
			}

			if (dataPair.getText().equals("Telephone number"))
			{
				if (dataPair.getValue().toString().length() != 10)
					telcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING);
			}

			if (newCharges - serviceCharges - callCharges != 0)
				telcoValidList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION);

		}
		
		return telcoValidList;
	}
}