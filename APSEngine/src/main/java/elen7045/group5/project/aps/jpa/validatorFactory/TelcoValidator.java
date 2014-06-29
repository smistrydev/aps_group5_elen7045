public class TelcoValidator extends Validator{
List<EDataErrors> TelcoValidList = new ArrayList<EDataErrors>();

TelcoValidator(){
super(EValidatorTypes.Municiple);
construct();
}

@Override
protected List<EDataErrors> PerformCaseSpecificValidation(int newcharges)
{
	
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
				TelcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		if (dataPair.getText().equals("Call charges"))
		{
			callCharges = Integer.parseInt(dataPair.getValue());
			if (callCharges < 0)
				TelcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		if (dataPair.getText().equals("New Charges"))
		{
			newCharges = Integer.parseInt(dataPair.getValue());
			if (newCharges < 0)
				TelcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		
		if (dataPair.getText().equals("Telephone number"))
		{
			if (dataPair.getValue().toString().length()!=10)
				TelcoValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
		}
		
		
		authenticateCharges(newcharges, serviceCharges, callcharges,)

		
	}	

}

private void authenticateCharges(int newcharge, int servicecharge, int callcharge)
{
	if(newCharges-serviceCharges-callCharges!=0)
		TelcoValidList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION(1001));
}



}