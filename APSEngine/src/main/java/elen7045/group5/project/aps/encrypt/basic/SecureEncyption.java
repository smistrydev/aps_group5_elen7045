package elen7045.group5.project.aps.encrypt.basic;

import org.jasypt.encryption.pbe.PBEStringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.jasypt.util.text.TextEncryptor;

public class SecureEncyption {

	public static void main(String[] args) {

		final String salt = "MySecretSalt";
		final String password = "MyFancyPassword01";

		TextEncryptor textEncryptor = new BasicTextEncryptor();
		((BasicTextEncryptor) textEncryptor).setPassword(salt);
		String encryptedPass = textEncryptor.encrypt(password);
		String plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("Basic  Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		textEncryptor = new BasicTextEncryptor();
		((BasicTextEncryptor) textEncryptor).setPassword(salt);
		encryptedPass = textEncryptor.encrypt(password);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("Basic  Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		encryptedPass = textEncryptor.encrypt(password);
		textEncryptor = new BasicTextEncryptor();
		((BasicTextEncryptor) textEncryptor).setPassword(salt);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("Basic  Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		textEncryptor = new StrongTextEncryptor();
		((StrongTextEncryptor) textEncryptor).setPassword(salt);
		encryptedPass = textEncryptor.encrypt(password);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("Strong Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		encryptedPass = textEncryptor.encrypt(password);
		textEncryptor = new StrongTextEncryptor();
		((StrongTextEncryptor) textEncryptor).setPassword(salt);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("Strong Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		encryptedPass = textEncryptor.encrypt(password);
		textEncryptor = new StrongTextEncryptor();
		((StrongTextEncryptor) textEncryptor).setPassword(salt);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("Strong Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		PBEStringEncryptor stringEncryptor = new StandardPBEStringEncryptor();
		stringEncryptor.setPassword(salt);
		((StandardPBEStringEncryptor) stringEncryptor).setAlgorithm("PBEWithMD5AndTripleDES");
		encryptedPass = stringEncryptor.encrypt(password);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("String Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			encryptedPass = stringEncryptor.encrypt(password);
		}
		System.out.println("100 std took: " + (System.currentTimeMillis() - start));

		stringEncryptor = new PooledPBEStringEncryptor();
		stringEncryptor.setPassword(salt);
		((PooledPBEStringEncryptor) stringEncryptor).setPoolSize(4);
		((PooledPBEStringEncryptor) stringEncryptor).setAlgorithm("PBEWithMD5AndTripleDES");
		encryptedPass = stringEncryptor.encrypt(password);
		plainText = textEncryptor.decrypt(encryptedPass);
		System.out.println("String Encrypted: " + encryptedPass + " - Decrypted: " + plainText);

		 start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			encryptedPass = stringEncryptor.encrypt(password);
		}
		System.out.println("100 std took: " + (System.currentTimeMillis() - start));

		
	}
}
