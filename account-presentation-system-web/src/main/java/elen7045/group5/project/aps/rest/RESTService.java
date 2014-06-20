package elen7045.group5.project.aps.rest;

import java.util.HashSet;
import java.util.Set;

/**
 * Contains the REST interface implementation 
 */
public class RESTService
{
	public Set<Class<?>> getClasses() {
	    Set<Class<?>> classes = new HashSet<Class<?>>();
	    classes.add(APSServices.class);
	    classes.add(JSONWriter.class);
	    classes.add(JSONReader.class);
	    return classes;
	  }
	  
	  public Set<Object> getSingletons() {
	    return null;
	    // nothing to do, no singletons
	  }


}
