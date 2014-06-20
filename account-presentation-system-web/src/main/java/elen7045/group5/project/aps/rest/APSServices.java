package elen7045.group5.project.aps.rest;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;

import org.apache.wink.common.model.wadl.Application;
import org.apache.wink.common.model.wadl.WADLGenerator;

/**
 * Defines the REST calls that can be made against the application
 */
@Path(value = "/services")
public class APSServices
{
//	private static final Logger LOG = Logger.getLogger(APSServices.class.getName());
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Context
	javax.ws.rs.core.Application app;

	@Context
	private HttpServletRequest request;

	@PostConstruct
	public void init()
	{
		// nothing needed for now
	}

	@javax.ws.rs.OPTIONS
	@Produces("application/vnd.sun.wadl+xml")
	public Application getOptions()
	{
		Application wadlAppDoc = new WADLGenerator().generate("", app.getClasses());
		/*
		 * modify the wadlAppDoc JAXB model if you want to add additional
		 * information
		 */
		return wadlAppDoc;
	}

	/**
	 * Method will return all the rule sets captured on the database along with
	 * their statuses
	 * 
	 * @param statusID
	 *            - Identifier that matches a particular status.
	 * @return Returns a list of {@link MetRulesChangeSetStatus} beans, an empty
	 *         set if nothing is defined
	 */
//	@Path(value = "/status/{status}")
//	@GET
//	@Produces({ MediaType.APPLICATION_JSON })
//	public List<MetRulesChangeSetStatus> getAllRuleSetsForStatus(@PathParam(value = "status") EMetRulesStatus status)
//	{
//		LOG.info("REST call XXX invoked");
//		return results;
//	}
}
