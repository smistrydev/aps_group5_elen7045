package elen7045.group5.project.aps.encrypt.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

/**
 * Utility for encrypting of text messages.
 * 
 * @author Sanjay Mistry
 *
 */
public class SecureAPSEncryptor implements APSEncryptor
{

	private StrongTextEncryptor	textEncryptor	= new StrongTextEncryptor();

	/**
	 * Creates a new instance of <tt>StrongTextEncryptor</tt>.
	 * 
	 * @param salt
	 *            a salt is set in the constructor.
	 */
	public SecureAPSEncryptor(String salt)
	{
		this.textEncryptor.setPassword(salt);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sanjay.test.encrypt.service.APSEncryptor#encrypt(java.lang.String)
	 */
	@Override
	public String encrypt(String message)
	{
		return this.textEncryptor.encrypt(message);
	}

	/**
	 * Decrypt a message
	 * 
	 * @param encryptedMessage
	 *            an encrypted message to be decrypted.
	 * @see StandardPBEStringEncryptor#decrypt(String)
	 */
	public String decrypt(String encryptedMessage)
	{
		return this.textEncryptor.decrypt(encryptedMessage);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sanjay.test.encrypt.service.APSEncryptor#check(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public boolean check(String plain, String encrypted)
	{
		String decrypted = this.decrypt(encrypted);
		boolean retVal = (plain.compareTo(decrypted) == 0);
		decrypted = null;
		return retVal;
	}

}
