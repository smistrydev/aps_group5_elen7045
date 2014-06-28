package elen7045.group5.project.wsa;

import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ScrapeSessionXMLUtil
{

	public static String toXML(ScrapeSession scrapeSession) throws JAXBException
	{

		StringWriter stringWriter = new StringWriter();

		JAXBContext context = JAXBContext.newInstance(ScrapeSession.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(scrapeSession, stringWriter);
		String result = stringWriter.toString();
		return result;

	}

	public static ScrapeSession fromXML(InputStream inputStream) throws JAXBException
	{

		JAXBContext context = JAXBContext.newInstance(ScrapeSession.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		ScrapeSession scrapeSession = (ScrapeSession) unmarshaller.unmarshal(inputStream);
		return scrapeSession;

	}
}
