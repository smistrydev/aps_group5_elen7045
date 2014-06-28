/**
 * 
 */
package elen7045.group5.project.notify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import elen7045.group5.project.aps.jpa.model.Notification;
import elen7045.group5.project.aps.jpa.service.NotificationService;
import elen7045.group5.project.notify.CreateErrorsXML;
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
	public String xmlNotificationMessage(EApplicationErrors errors)
	{

		int errorCode = errors.getErrorCode();

		Notification notification = this.notificationService.findById(errorCode);

		CreateErrorsXML xmlError = new CreateErrorsXML();
		xmlError.setErrorCode(errorCode);
		xmlError.setErrorMessage(notification.getNotificationDescription());

		String retValue = xmlError.getXMlErrorMessage();
		
		return retValue;
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EUserInterfaceErrors)
	 */
	@Override
	public String xmlNotificationMessage(EUserInterfaceErrors errors)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EScrapperSchedularErrors)
	 */
	@Override
	public String xmlNotificationMessage(EScrapperSchedularErrors errors)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see elen7045.group5.project.notify.service.IApplicationNotificationService#xmlNotificationMessage(elen7045.group5.project.notify.EDataErrors)
	 */
	@Override
	public String xmlNotificationMessage(EDataErrors errors)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
