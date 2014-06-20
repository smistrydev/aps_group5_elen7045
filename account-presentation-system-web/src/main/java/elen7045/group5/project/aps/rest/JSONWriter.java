package elen7045.group5.project.aps.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Class provides a mechanism to convert objects into JSON
 */
@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JSONWriter implements MessageBodyWriter<Object>
{
	@Override
	public long getSize(Object arg0, Class<?> arg1, Type arg2, Annotation[] arg3, MediaType arg4)
	{
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3)
	{
		return true;
	}

	@Override
	public void writeTo(Object object, Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> headers, OutputStream out) throws IOException
	{
		String jsonString = null;

		GsonBuilder serializedJson = new GsonBuilder();
		serializedJson.registerTypeAdapter(Date.class, new DateAdapter());

		Gson gson = serializedJson.create();
		jsonString = gson.toJson(object);
		out.write(jsonString.getBytes());
	}
}