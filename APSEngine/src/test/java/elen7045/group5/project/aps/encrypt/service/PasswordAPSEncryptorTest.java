package elen7045.group5.project.aps.encrypt.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.*;

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

	// Feature 1: Customer Password one way encryption
	@Test
	public void testOneWayEncryption()
	{
		String password = "SecureP@s5";
		APSEncryptor apsEncryptor = new PasswordAPSEncryptor();
		String encryptedPass = apsEncryptor.encrypt(password);

		assertNotNull(encryptedPass);
		assertNotEquals(password, encryptedPass);
	}

	// Feature 2: Customer Password verification when signing in APS
	@Test
	public void testVerifyPassword()
	{
		String password = "SecureP@s5";
		APSEncryptor apsEncryptor = new PasswordAPSEncryptor();
		String originalEncryptedPass = apsEncryptor.encrypt(password);

		String password2 = "SecureP@s5";
		boolean result = apsEncryptor.check(password2, originalEncryptedPass);

		assertTrue(result);
	}

	// Feature 3: Customer Password cannot be decrypted
	@Test
	public void testFailAttemptToDecryptPassword()
	{
		String password = "SecureP@s5";
		APSEncryptor apsEncryptor = new PasswordAPSEncryptor();
		String originalEncryptedPass = apsEncryptor.encrypt(password);

		String attemptUnEncrypt = apsEncryptor.encrypt(originalEncryptedPass);
		boolean result = apsEncryptor.check(attemptUnEncrypt, originalEncryptedPass);

		assertFalse(result);
	}

}
