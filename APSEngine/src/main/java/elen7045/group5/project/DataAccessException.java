package elen7045.group5.project;

/**
 * This exception type is used to wrap any type of exception that involves accessing 
 * data through I/O operations (files) and TCP calls (database). The reason for having 
 * this wrapper is to shield what type of resource is being accessed. To elaborate, 
 * if an object throws <i>java.lang.IOException</i> the caller has to cater for this type 
 * of exception. If we later change the data source from a file to a database, we now throw 
 * <i>java.sql.SQLException</i> which means the calling code has to change as well. Using this 
 * wrapper prevents that from happening.
 */
public class DataAccessException extends RuntimeException
{
	private static final long serialVersionUID = 13323232L;

	/**
	 * Default constructor
	 */
	public DataAccessException()
	{
		super();
	}

	/**
	 * Constructor that accepts a description of the exception as an argument.
	 * @param s The error that occurred when trying to access the data source
	 */
	public DataAccessException(String message)
	{
		super(message);
	}

	/**
	 * Allows the exception to be chained 
	 * @param cause - Exception object that was thrown
	 */
	public DataAccessException(Throwable cause)
	{
		super(cause);
	}

	/**
	 * Allows the exception to be chained, along with a message on
	 * the exception
	 * @param message - Message of the exception
	 * @param cause - Exception object that was thrown
	 */
	public DataAccessException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.getMessage());
		sb.append(System.getProperty("line.separator"));
		
		StackTraceElement[] el = super.getStackTrace();
		for(int r = 0; r < el.length; r++)
		{
			sb.append(el[r].toString());
			if((r+1) < el.length)
				sb.append(System.getProperty("line.separator"));
		}
		
		return sb.toString();
	}
}
