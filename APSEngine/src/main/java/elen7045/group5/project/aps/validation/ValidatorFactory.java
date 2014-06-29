package elen7045.group5.project.aps.validation;

/**
 * Factory will create a validator based on the type of statement scraped.
 */
public class ValidatorFactory
{
	/**
	 * Returns a validator based on the type
	 * @param model
	 * @return
	 */
	public static Validator ValidatorBuilder(EValidatorTypes model)
	{
		Validator validator = null;
		switch (model)
		{
		case CreditCard:
			validator = new CreditCardValidator();
			break;
		case Municiple:
			validator = new MunicipleValidator();
			break;
		case Telco:
			validator = new TelcoValidator();
		default:
			// throw an exeption
			break;
		}
		return validator;

	}
}