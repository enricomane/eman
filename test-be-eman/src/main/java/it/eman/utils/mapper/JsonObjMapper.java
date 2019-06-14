package it.eman.utils.mapper;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.ObjectMapper;

@Component
public class JsonObjMapper implements ObjectMapper {

	private com.fasterxml.jackson.databind.ObjectMapper jsonObjectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
	
	@Override
	public <T> T readValue(String value, Class<T> valueType) {
		try {
			return jsonObjectMapper.readValue(value, valueType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String writeValue(Object value) {
		try {
			return jsonObjectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
