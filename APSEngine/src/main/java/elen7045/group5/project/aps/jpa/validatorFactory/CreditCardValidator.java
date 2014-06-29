public class CreditCardValidator extends Validator {
	
	
	int		minimumAmountDue,
			newCharges;
	
	CreditCardValidator() {
		super(EValidatorTypes.CreditCard);
		PerformCaseSpecificValidation();
	}

	@Override
	protected List<EDataErrors> PerformCaseSpecificValidation(int newcharges) {
		List<EDataErrors> creditCardValidList = new ArrayList<EDataErrors>(); 
		List<ScrapeSession.Datapair> dataPairList =  scrape.getDatapair();
		
		for(ScrapeSession.Datapair dataPair : dataPairList)
		{
			
			if(dataPair.getText().equals("Minimum amount due"))
			{
				minimumAmountDue=Integer.parseInt(dataPair.getValue());
				if (minimumAmountDue<0)
					creditCardValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if(dataPair.getText().equals("New charges"))
			{
				newCharges=Integer.parseInt(dataPair.getValue());
				if (totalDue<0)
					creditCardValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			
			
			
			if (minimumAmountDue!=newCharges)
				creditCardValidList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION(1001))
			
			
		}
		return creditCardValidList;
	}

}
