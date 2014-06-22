package elen7045.group5.project.aps.encrypt.service;

import org.jasypt.digest.StandardStringDigester;

/**
 * Common interface to secure message via encryption.
 * 
 * @author Sanjay Mistry
 */
public interface APSEncryptor
{

	/**
	 * Encrypts (digests) a message
	 * 
	 * @param message
	 *            a message to be encrypted.
	 * @return the resulting digest.
	 */
	String encrypt(String message);

	/**
	 * Checks an unencrypted (plain) against an encrypted one (a digest) to see
	 * if they match.
	 * 
	 * @param plain
	 *            the plain to check.
	 * @param encrypted
	 *            the digest against which to check the plain.
	 * @return true if messages match, false if not.
	 * @see StandardStringDigester#matches(String, String)
	 */
	public boolean check(String plain, String encrypted);

}
