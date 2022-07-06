package com.siemens.aps.odata.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siemens.aps.odata.mustache.Context;

public class JsonProcessor {

	/**
	 * This is just returning a list of properties. Will be processing the sparql json response in future
	 * @return
	 * @throws JsonProcessingException 
	 * @throws JsonMappingException 
	 */
	public List<Context.Property> processJson() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Context.Property> properties = new ArrayList<Context.Property>();
		JsonNode jsonNode = objectMapper.readTree(getJson());
		jsonNode
        .iterator()
        .forEachRemaining(
            json -> {
              var value = Objects.nonNull(json.get("propertyLabel")) ? json.get("propertyLabel").get("value").asText() : null;
              Context.Property property = new Context.Property(value, null);
              properties.add(property);
            });
		
		return properties;
	}
	
	public String getJson() {
		var json = "[{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"uneceCode\"}},{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"label\"}},{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"opcUaId\"}},{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"translationIdLabel\"}},{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"translationIdSymbol\"}},{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"symbol\"}},{\"propertyLabel\":{\"type\":\"literal\",\"value\":\"uddId\"}}]";
		
		return json;
	}
}
