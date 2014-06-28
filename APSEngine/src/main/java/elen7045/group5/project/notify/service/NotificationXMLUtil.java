package elen7045.group5.project.notify.service;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class NotificationXMLUtil
{

	public static String toXML(NotificationMessage notificationMessage) throws JAXBException
	{

		StringWriter stringWriter = new StringWriter();

		JAXBContext context = JAXBContext.newInstance(NotificationMessage.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(notificationMessage, stringWriter);
		String result = stringWriter.toString();
		return result;

	}

	public static NotificationMessage fromXML(String xmlString) throws JAXBException
	{
		StringReader reader = new StringReader(xmlString);

		JAXBContext context = JAXBContext.newInstance(NotificationMessage.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		NotificationMessage message = (NotificationMessage) unmarshaller.unmarshal(reader);
		return message;

	}
}
