/**
 * 
 */
package elen7045.group5.project.aps;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import elen7045.group5.project.aps.config.ApplicationContext;

/**
 * 
 * @author Sanjay Mistry
 */
public class Run
{

	/**
	 * 
	 */
	public Run()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		AbstractApplicationContext context = null;

		try
		{
			context = new AnnotationConfigApplicationContext(
					ApplicationContext.class);
			
			AccountPresentationEngine accountPresentationEngine = context
					.getBean(AccountPresentationEngine.class);
			accountPresentationEngine.init();
			accountPresentationEngine.startApplication();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			((AbstractApplicationContext) context).close();
		}

		System.exit(0);

	}

}
