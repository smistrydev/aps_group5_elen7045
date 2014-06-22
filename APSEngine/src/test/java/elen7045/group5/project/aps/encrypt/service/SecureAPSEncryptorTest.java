package elen7045.group5.project.aps.encrypt.service;

import static org.junit.Assert.*;

import org.jasypt.util.text.StrongTextEncryptor;
import org.junit.Test;

public class SecureAPSEncryptorTest {

	@Test
	public void testEncrypt() {
		final String  salt = "balh8Blah";
		SecureAPSEncryptor apsEncryptor = new SecureAPSEncryptor(salt);

		String message = "Some Secret Message 123";
		
		String encryptedMsg = apsEncryptor.encrypt(message);
		
		StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
		textEncryptor.setPassword(salt);
		String plainMsg = textEncryptor.decrypt(encryptedMsg);
		assertEquals(message, plainMsg);
	}

	@Test
	public void testDecrypt() {
		final String  salt = "balh8Blah";
		SecureAPSEncryptor apsEncryptor = new SecureAPSEncryptor(salt);

		String message = "Some Secret Message 123";

		String encryptedMsg = apsEncryptor.encrypt(message);
		String plainMsg = apsEncryptor.decrypt(encryptedMsg);
		assertEquals(message, plainMsg);
	}

	@Test
	public void testCheck() {
		final String  salt = "balh8Blah";
		SecureAPSEncryptor apsEncryptor = new SecureAPSEncryptor(salt);

		String message = "Some Secret Message 123";

		String encryptedMsg = apsEncryptor.encrypt(message);
		assertTrue(apsEncryptor.check(message, encryptedMsg));
	}

}
