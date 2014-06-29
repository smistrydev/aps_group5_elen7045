public class TelcoValidator extends Validator{


TelcoValidator(){
super(EValidatorTypes.Municiple);
construct();
}

@Override
protected List<EDataErrors> PerformCaseSpecificValidation(int newcharges)
{
	List<EDataErrors> TelcoValidList = new ArrayList<EDataErrors>();
	List<ScrapeSession.Datapair> dataPairList = scrape.getDatapair();
	
	int serviceCharges,
		callCharges,
		newCharges;
	
	for (ScrapeSession.Datapair dataPair : dataPairList)
	{
		if (dataPair.getText().equals("Service charges"))
		{
			serviceCharges = Integer.parseInt(dataPair.getValue());
			if (serviceCharges < 0)
				MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		if (dataPair.getText().equals("Call charges"))
		{
			callCharges = Integer.parseInt(dataPair.getValue());
			if (callCharges < 0)
				MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		if (dataPair.getText().equals("New Charges"))
		{
			newCharges = Integer.parseInt(dataPair.getValue());
			if (newCharges < 0)
				MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		
		if (dataPair.getText().equals("Telephone number"))
		{
			if (dataPair.getValue().toString().length()!=10)
				MunicipleValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		
		if(newCharges-serviceCharges-callCharges!=0)
			MunicipleList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION(1001));

		
	}	

}




}