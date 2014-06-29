public class MunicipleValidator extends Validator
{

	MunicipleValidator()
	{
		super(EValidatorTypes.Municiple);
		construct();
	}

	private void PerformValidation()
	{
		// Base class holds none
	}

	@Override
	protected List<EDataErrors> PerformCaseSpecificValidation(int newcharges)
	{
		List<EDataErrors> MunicipleValidList = new ArrayList<EDataErrors>();
		List<ScrapeSession.Datapair> dataPairList = scrape.getDatapair();
		
		
		int		electricityCharges,
				gasCharges,
				waterCharges,
				sewerageCharges,
				refuseCharges,
				newCharges;

		for (ScrapeSession.Datapair dataPair : dataPairList)
		{

			if (dataPair.getText().equals("Electricity charges"))
			{
				electricityCharges = Integer.parseInt(dataPair.getValue());
				if (electricityCharges < 0)
					MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if (dataPair.getText().equals("Gas charges"))
			{
				gasCharges = Integer.parseInt(dataPair.getValue());
				if (minimumAmountDue < 0)
					MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if (dataPair.getText().equals("Sewerage charges"))
			{
				sewerageCharges = Integer.parseInt(dataPair.getValue());
				if (sewerageCharges < 0)
					MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if (dataPair.getText().equals("Water charges"))
			{
				waterCharges = Integer.parseInt(dataPair.getValue());
				if (waterCharges < 0)
					MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if (dataPair.getText().equals("Refuse charges"))
			{
				refuseCharges = Integer.parseInt(dataPair.getValue());
				if (refuseCharges < 0)
					MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if (dataPair.getText().equals("New Charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges < 0)
					MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if (newCharges-electricityCharges-gasCharges-waterCharges-sewerageCharges-refuseCharges!=0)
				MunicipleList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION(1001));
		}

	}

}