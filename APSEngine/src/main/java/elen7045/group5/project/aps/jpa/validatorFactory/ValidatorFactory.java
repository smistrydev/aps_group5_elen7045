public class ValidatorFactory {
	public static Validator ValidatorBuilder(EValidatorTypes model) {
		Validator validator = null;
		switch (model) {
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