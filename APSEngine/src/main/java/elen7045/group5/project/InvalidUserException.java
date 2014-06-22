package elen7045.group5.project;

/**
 * This exception is thrown if the user's credentials is not valid
 */
public class InvalidUserException extends Exception
{
	private static final long	serialVersionUID	= 113131L;

	/**
	 * InvalidUserException constructor.
	 */
	public InvalidUserException()
	{
		super();
	}

	/**
	 * InvalidUserException constructor.
	 * 
	 * @param s
	 *            java.lang.String The exception encountered
	 */
	public InvalidUserException(String s)
	{
		super(s);
	}

}