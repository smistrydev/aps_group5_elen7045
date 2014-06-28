package elen7045.group5.project.notify;

import elen7045.group5.project.aps.jpa.model.Notification;
import elen7045.group5.project.aps.jpa.service.NotificationService;

public class ErrorMessagesFromTheDB
{
	private String				errorMessageFromDB;
	private int					errorCode;
	private NotificationService	service;
	private Notification		notification;

	public ErrorMessagesFromTheDB(int errorCode)
	{
		this.errorCode = errorCode;
		//fetchErrorMessageFromDB();
	}

	public String getErrorMessage()
	{
		return errorMessageFromDB;
	}

	private void fetchErrorMessageFromDB()
	{
		Integer error = new Integer(errorCode);
		notification = service.findById(error);
		errorMessageFromDB = notification.getNotificationDescription();
		// errorMessageFromDB =
	}
}
