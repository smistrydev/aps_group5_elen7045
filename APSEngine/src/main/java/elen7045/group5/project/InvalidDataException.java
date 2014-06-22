package elen7045.group5.project;

import java.io.Serializable;

/**
 * Thrown when the data entered by the user is not valid, e.g. the date is in
 * the incorrect format. This object also allows the caller to enter a list of
 * all the errors encountered e.g. when validating a scrape message, to allow
 * the client to see all the incorrect information at once and eliminates the
 * need to go back and forth for one single error at a time.
 */
public class InvalidDataException extends RuntimeException implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	private String[]			messages;

	/**
	 * InvalidDataException constructor.
	 */
	public InvalidDataException()
	{
		super();
	}

	/**
	 * InvalidDataException constructor.
	 * 
	 * @param s
	 *            The exception encountered
	 */
	public InvalidDataException(String s)
	{
		super(s);
	}

	/**
	 * This constructor accepts an array of String messages ss a parameter. The
	 * reason for this is if we are evaluating the data entered by the client
	 * and we find that some of it is invalid, we can use the array to store all
	 * the invalid fields and pass this as an exception so that the user can see
	 * all the incorrect information at once and does not need to go back and
	 * forth for one single error at a time.
	 * 
	 * @param msg
	 *            - An array of errors encountered
	 */
	public InvalidDataException(String[] msg)
	{
		super();
		messages = msg;
	}

	/**
	 * This method returns the message array associated with this exception. The
	 * array contains all the messages for the user and this way prevents going
	 * back and forward as all the messages can be displayed at once to the
	 * client
	 * 
	 * @return Array containing all the messages for the client
	 */
	public String[] getMessageList()
	{
		return messages;
	}
}