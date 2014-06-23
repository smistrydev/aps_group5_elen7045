package elen7045.group5.project.notify;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ErrorDateTimeStamp {
	
		
		private String timeStamp;	
		
		
		
		private void setupSystemDateTime()
		{
			timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		}
		
		public String getSystemDateTime()
		{
			setupSystemDateTime();
			return timeStamp;
		}
		
		public String getXMLName()
		{
		 return "TimeStamp";
		}
	}



