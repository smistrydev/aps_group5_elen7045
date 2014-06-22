package elen7045.group5.project.aps.encrypt.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.junit.Test;

public class PasswordAPSEncryptorTest
{

	@Test
	public void testEncrypt()
	{
		PasswordAPSEncryptor apsEncryptor = new PasswordAPSEncryptor();

		String password = "Th#sIs@Fu&nyPass01";
		String encryptedPass = apsEncryptor.encrypt(password);

		assertNotNull(encryptedPass);
		assertFalse(encryptedPass.isEmpty());

		BasicPasswordEncryptor basicPasswordEncryptor = new BasicPasswordEncryptor();
		assertTrue(basicPasswordEncryptor.checkPassword(password, encryptedPass));
	}

	@Test
	public void testCheck()
	{
		PasswordAPSEncryptor apsEncryptor = new PasswordAPSEncryptor();

		String password = "Th#sIs@Fu&nyPass01";
		String encryptedPass = apsEncryptor.encrypt(password);
		assertTrue(apsEncryptor.check(password, encryptedPass));

	}

}
