/**
 * 
 */
package elen7045.group5.project.notify.service;

import java.util.Date;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.jpa.model.Notification;
import elen7045.group5.project.aps.jpa.service.NotificationService;
import elen7045.group5.project.notify.EApplicationErrors;
import elen7045.group5.project.notify.EDataErrors;
import elen7045.group5.project.notify.EScrapperSchedularErrors;
import elen7045.group5.project.notify.EUserInterfaceErrors;

/**
 * 
 * @author Sanjay Mistry
 */
@Component
public class ApplicationNotificationServiceImpl implements IApplicationNotificationService
{

	@Autowired
	private NotificationService	notificationService;

	/**
	 * 
	 */
	public ApplicationNotificationServiceImpl()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EApplicationErrors)
	 */
	@Override
	public String notificationMessageToXML(EApplicationErrors errors)
	{
		Notification notification = this.notificationService.findById(errors.getErrorCode());

		return this.convert(notification);
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EUserInterfaceErrors)
	 */
	@Override
	public String notificationMessageToXML(EUserInterfaceErrors errors)
	{
		Notification notification = this.notificationService.findById(errors.getErrorCode());

		return this.convert(notification);
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EScrapperSchedularErrors)
	 */
	@Override
	public String notificationMessageToXML(EScrapperSchedularErrors errors)
	{
		Notification notification = this.notificationService.findById(errors.getErrorCode());

		return this.convert(notification);
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EDataErrors)
	 */
	@Override
	public String notificationMessageToXML(EDataErrors errors)
	{
		Notification notification = this.notificationService.findById(errors.getErrorCode());

		return this.convert(notification);
	}

	private String convert(Notification notification)
	{
		NotificationMessage notificationMessage = new NotificationMessage();
		notificationMessage.setNotificationCode(notification.getNotificationId());
		notificationMessage.setNotificationMessage(notification.getNotificationDescription());
		notificationMessage.setTimeStamp(new Date());

		String xmlString = null;
		try
		{
			xmlString = NotificationXMLUtil.toXML(notificationMessage);
		}
		catch (JAXBException e)
		{
			e.printStackTrace();
		}

		return xmlString;
	}

}
