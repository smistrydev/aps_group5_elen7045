package elen7045.group5.project.aps.validation;

import elen7045.group5.project.aps.jpa.model.EStatementProvider;

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
	public static Validator getValidator(EStatementProvider providerType)
	{
		Validator validator = null;
		switch (providerType)
		{
		case CREDIT_CARD:
			validator = new CreditCardValidator();
			break;
		case MUNICIPAL:
			validator = new MunicipleValidator();
			break;
		case TELCO:
			validator = new TelcoValidator();
		default:
			// throw an exeption
			break;
		}
		return validator;
	}
}