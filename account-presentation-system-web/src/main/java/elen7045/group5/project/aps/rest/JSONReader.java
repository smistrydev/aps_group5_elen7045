package elen7045.group5.project.aps.rest;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Consumes(MediaType.APPLICATION_JSON)
@Provider
public class JSONReader implements MessageBodyReader<Object> {

  @Override
  public boolean isReadable(Class<?> arg0, Type arg1, Annotation[] arg2, MediaType arg3) {
    return true;
  }

  @Override
  public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> headers, InputStream in) throws IOException {

    Type jsonType = null;    
    Gson deserGSon = new GsonBuilder().create();
    if (!type.equals(genericType)) {
      jsonType = genericType;
    } else {
      jsonType = type;
    }

    return deserGSon.fromJson(new InputStreamReader(in), jsonType);
  }

}
