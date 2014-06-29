package elen7045.group5.project.aps.validation;

import java.util.ArrayList;
import java.util.List;

import elen7045.group5.project.notify.EDataErrors;
import elen7045.group5.project.wsa.ScrapeSession;


/**
 * Validation specific to Municipal statements being scraped
 */
public class MunicipleValidator extends Validator
{

	/**
	 * Default constructor
	 */
	MunicipleValidator()
	{
		super(EValidatorTypes.Municiple);
	}
	
	/**
	 * @see elen7045.group5.project.aps.validator.Validator#performCaseSpecificValidation(elen7045.group5.project.wsa.ScrapeSession)
	 */
	protected List<ValidationErrorBean> performCaseSpecificValidation(ScrapeSession scrapeData)
	{
		List<ValidationErrorBean> municipleValidList = new ArrayList<ValidationErrorBean>();
		List<ScrapeSession.Datapair> dataPairList = scrapeData.getDatapair();
				
		float	electricityCharges = 0.0F,
				gasCharges = 0.0F,
				waterCharges = 0.0F,
				sewerageCharges = 0.0F,
				refuseCharges = 0.0F,
				newCharges = 0.0F;

		for (ScrapeSession.Datapair dataPair : dataPairList)
		{
			if (dataPair.getText().equals("Electricity charges"))
			{
				electricityCharges = Integer.parseInt(dataPair.getValue());
				if (electricityCharges < 0)
					municipleValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}
			
			if (dataPair.getText().equals("Gas charges"))
			{
				gasCharges = Integer.parseInt(dataPair.getValue());
				if (gasCharges < 0)
					municipleValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}
			
			if (dataPair.getText().equals("Sewerage charges"))
			{
				sewerageCharges = Integer.parseInt(dataPair.getValue());
				if (sewerageCharges < 0)
					municipleValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}
			
			if (dataPair.getText().equals("Water charges"))
			{
				waterCharges = Integer.parseInt(dataPair.getValue());
				if (waterCharges < 0)
					municipleValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}
			
			if (dataPair.getText().equals("Refuse charges"))
			{
				refuseCharges = Integer.parseInt(dataPair.getValue());
				if (refuseCharges < 0)
					municipleValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}
			
			if (dataPair.getText().equals("New Charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges < 0)
					municipleValidList.add(new ValidationErrorBean(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING, dataPair.getText()));
			}
			
			if (newCharges-electricityCharges-gasCharges-waterCharges-sewerageCharges-refuseCharges!=0)
				municipleValidList.add(new ValidationErrorBean(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION, dataPair.getText()));
		}
		
		return municipleValidList;
	}
}