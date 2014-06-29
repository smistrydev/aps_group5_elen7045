import java.util.ArrayList;
import java.util.List;

import com.converter.beans.ScrapeSession;

public abstract class Validator
{

	public Validator(EValidatorTypes model)
	{
		this.model = model;
	}

	private List<EDataErrors> PerformValidation(ScrapeSession scrape) {
		//boolean dataCompletelyValid=true;
		
		int	accountNumber, // general
		statementNumber,
		openingBalance,
		closingBalance,
		newCharges,
		discount,
		deductions,
		totalDue,
		paymentsRecieved;

String	accountHolderName, //general
		StatementMonth,
		statementDate,
		dueDate;


		
		//run through all the data pairs and if you get an exception4
		//create a new ValidationException and add the code to it
		List<EDataErrors> ValidList = new ArrayList<EDataErrors>(); 
		List<EDataErrors> TypeSpecificValidList = new ArrayList<EDataErrors>(); 
		List<ScrapeSession.Datapair> dataPairList =  scrape.getDatapair();
		for(ScrapeSession.Datapair dataPair : dataPairList)
		{
			if(dataPair.getText().equals("Account Number"))
			{
				//No test relates to this field
			}

			
			if(dataPair.getText().equals("Total due"))
			{
				totalDue=Integer.parseInt(dataPair.getValue());
				if (totalDue<0)
					ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if(dataPair.getText().equals("Deductions"))
			{
				deductions = Integer.parseInt(dataPair.getValue());
				if (deductions<0)
					ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if(dataPair.getText().equals("New charges"))
			{
				newCharges = Integer.parseInt(dataPair.getValue());
				if (newCharges<0)
					ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
				//No test relates to this field
			}
			
			if(dataPair.getText().equals("Payment recieved"))
			{
				paymentsRecieved = Integer.parseInt(dataPair.getValue());
				if (paymentsRecieved<0)
					ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if(dataPair.getText().equals("Discount"))
			{
				discount = Integer.parseInt(dataPair.getValue());
				if (discount<0)
					ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			}
			
			if(dataPair.getText().equals("Opening balance"))
			{
				try {
			        openingBalance = Integer.parseInt(dataPair.getValue());
			    }
			    catch( Exception e ) {
			    	ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			    }
			}
			
			if(dataPair.getText().equals("Closing balance"))
			{
				try {
			        closingBalance = Integer.parseInt(dataPair.getValue());
			    }
			    catch( Exception e ) {
			    	ValidList.add(EDataErrors.DATA_FAILS_INTEGRITY_CHECKING(1005));
			    }
			}
			
			int ActualTotal = openingBalance + paymentsRecieved - newCharges + discount + deductions;
			if (totalDue != -ActualTotal)
			{
				ValidList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION(1001))
			}

			if (openingBalance - totalDue != closingBalance)
			{
				ValidList.add(EDataErrors.INCORRECT_TOTAL_DUE_CALCULATION(1001))
			}
		
		}
		
		TypeSpecificValidList=PerformCaseSpecificValidation(newcharges);  //Calls Enums to perform account specific error checks
		ValidList.addAll(TypeSpecificValidList); //Adds the errors of the account specific check to the main list of errors.
		
		return ValidList;
	}

	protected abstract List<EDataErrors> PerformCaseSpecificValidation(); 
																			

	private EValidatorTypes	model	= null;

	public EValidatorTypes getModel()
	{
		return model;
	}

	public void setModel(EValidatorTypes model)
	{
		this.model = model;
	}

}
