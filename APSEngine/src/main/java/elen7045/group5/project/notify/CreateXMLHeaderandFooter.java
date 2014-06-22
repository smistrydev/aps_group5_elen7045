package elen7045.group5.project.notify;

public class CreateXMLHeaderandFooter {
	private String fieldName;
    private String convertName;
	  
		public CreateXMLHeaderandFooter(String name)
		{
			convertName = name;
		}
		public String createXMLHeader( )
		{
	     return fieldName = "<" + convertName +">";	     
			
		}
		public String createXMLFooter()
		{
		return fieldName = "<" + convertName +"/>";
		
		}
		
	}


