/**
 * 
 */
package elen7045.group5.project.aps.encrypt.basic;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;

/**
 * @author i300716
 *
 */
public class PasswordEncyptOneWay {

	public static void main(String[] args) {

		final String password = "MyFancyPassword01";
		
		PasswordEncryptor encryptor = new BasicPasswordEncryptor();

		String passTest = encryptor.encryptPassword(password);
		boolean isOkay = encryptor.checkPassword(password, passTest);
		System.out.println("password encrypted by Basic password encryptor: " + passTest + " - Test Check:" + isOkay);

		passTest = encryptor.encryptPassword(password);
		System.out.println("password encrypted by Basic password encryptor: " + passTest);

		passTest = encryptor.encryptPassword(password);
		System.out.println("password encrypted by Basic password encryptor: " + passTest);

		encryptor = new StrongPasswordEncryptor();

		passTest = encryptor.encryptPassword(password);
		isOkay = encryptor.checkPassword(password, passTest);
		System.out.println("password encrypted by Basic password encryptor: " + passTest + " - Test Check:" + isOkay);

		passTest = encryptor.encryptPassword(password);
		System.out.println("password encrypted by Basic password encryptor: " + passTest);

		passTest = encryptor.encryptPassword(password);
		System.out.println("password encrypted by Basic password encryptor: " + passTest);

		encryptor = new ConfigurablePasswordEncryptor();
		((ConfigurablePasswordEncryptor) encryptor).setAlgorithm("SHA-512");
		
		passTest = encryptor.encryptPassword(password);
		isOkay = encryptor.checkPassword(password, passTest);
		System.out.println("password encrypted by Basic password encryptor: " + passTest + " - Test Check:" + isOkay);

		passTest = encryptor.encryptPassword(password);
		System.out.println("password encrypted by Basic password encryptor: " + passTest);

		passTest = encryptor.encryptPassword(password);
		System.out.println("password encrypted by Basic password encryptor: " + passTest);

	}

}
