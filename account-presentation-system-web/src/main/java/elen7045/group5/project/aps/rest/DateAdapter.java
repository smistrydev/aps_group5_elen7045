package elen7045.group5.project.aps.rest;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * Provides a date conversion implementation for the JSON
 */
public class DateAdapter implements JsonSerializer<Date>, JsonDeserializer<Date>
{
	/**
	 * @see com.google.gson.JsonDeserializer#deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext)
	 */
	@Override
	public Date deserialize(JsonElement srcJson, Type typeOfSrc,
			JsonDeserializationContext ctx) throws JsonParseException
	{
		if (srcJson.isJsonNull())
		{
			return null;
		}
		if (!srcJson.isJsonPrimitive() || !srcJson.getAsJsonPrimitive().isNumber())
		{
			throw new JsonParseException(
					"Invalid type for Date, must be a numeric timestamp!");
		}

		return new Date(srcJson.getAsLong());
	}

	/**
	 * @see com.google.gson.JsonSerializer#serialize(java.lang.Object, java.lang.reflect.Type, com.google.gson.JsonSerializationContext)
	 */
	@Override
	public JsonElement serialize(Date srcDate, Type typeOfT, JsonSerializationContext ctx)
	{
		if (srcDate == null)
		{
			return JsonNull.INSTANCE;
		}
		return new JsonPrimitive(srcDate.getTime());
	}

}
