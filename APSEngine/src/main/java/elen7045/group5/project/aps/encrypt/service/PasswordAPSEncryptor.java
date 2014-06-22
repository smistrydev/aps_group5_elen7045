package elen7045.group5.project.aps.encrypt.service;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.jasypt.util.password.PasswordEncryptor;

/**
 * Utility class for password digest and checking
 * 
 * @author Sanjay Mistry
 */
public class PasswordAPSEncryptor implements APSEncryptor
{

	private PasswordEncryptor	encryptor	= new BasicPasswordEncryptor();

	/**
	 * Creates a new instance of <tt>PasswordAPSEncryptor</tt>
	 */
	public PasswordAPSEncryptor()
	{
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
		return encryptor.encryptPassword(message);
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
		return encryptor.checkPassword(plain, encrypted);
	}

}
