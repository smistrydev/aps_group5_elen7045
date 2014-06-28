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

	String xmlNotificationMessage(EApplicationErrors applicationErrors);

	String xmlNotificationMessage(EUserInterfaceErrors userInterfaceErrors);

	String xmlNotificationMessage(EScrapperSchedularErrors scrapperSchedularErrors);

	String xmlNotificationMessage(EDataErrors dataErrors);

}
