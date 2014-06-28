/**
 * 
 */
package elen7045.group5.project.notify.service;

import elen7045.group5.project.notify.EApplicationErrors;
import elen7045.group5.project.notify.EDataErrors;
import elen7045.group5.project.notify.EScrapperSchedularErrors;
import elen7045.group5.project.notify.EUserInterfaceErrors;

/**
 * 
 * @author Sanjay Mistry
 */
public interface IApplicationNotificationService
{

	String notificationMessageToXML(EApplicationErrors applicationErrors);

	String notificationMessageToXML(EUserInterfaceErrors userInterfaceErrors);

	String notificationMessageToXML(EScrapperSchedularErrors scrapperSchedularErrors);

	String notificationMessageToXML(EDataErrors dataErrors);

}
