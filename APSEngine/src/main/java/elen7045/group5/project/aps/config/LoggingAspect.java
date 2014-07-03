/**
 * 
 */
package elen7045.group5.project.aps.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Sanjay Mistry
 */
@Aspect
public class LoggingAspect
{

	@Around("@annotation(APSAuditLog)")
	public void auditLogAround(ProceedingJoinPoint joinPoint) throws Throwable
	{

		Logger logger = LoggerFactory.getLogger("APS");

		Object object = joinPoint.proceed();

		if (object != null)
		{
			if (object instanceof String)
			{
				// This is a simple example of getting handle of returning object
				logger.debug(object.toString());
				
				// Code here to write off the Scrape Data Audit Log.
			}
		}

	}

}
