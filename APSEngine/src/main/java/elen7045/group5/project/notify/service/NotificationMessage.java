/**
 * 
 */
package elen7045.group5.project.notify.service;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author Sanjay Mistry
 */
@XmlRootElement(name = "Notification")
@XmlType(propOrder = { "notificationCode", "notificationMessage", "timeStamp" })
public class NotificationMessage
{

	private String	notificationCode;

	private String	notificationMessage;

	private Date	timeStamp;

	/**
	 * 
	 */
	public NotificationMessage()
	{
	}

	public String getNotificationCode()
	{
		return notificationCode;
	}

	public void setNotificationCode(String notificationCode)
	{
		this.notificationCode = notificationCode;
	}

	public void setNotificationCode(int notificationCode)
	{
		this.notificationCode = String.format("%04d", notificationCode);
	}

	public String getNotificationMessage()
	{
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage)
	{
		this.notificationMessage = notificationMessage;
	}

	public Date getTimeStamp()
	{
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp)
	{
		this.timeStamp = timeStamp;
	}

}
