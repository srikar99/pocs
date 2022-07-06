package com.siemens.aps.process;

import java.io.IOException;
import java.util.Objects;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.siemens.aps.model.Asset;

public class AssetDeserializer extends StdDeserializer<Asset> {

	private static final long serialVersionUID = -825174169543704456L;

	public AssetDeserializer() { 
        this(null); 
    } 

    public AssetDeserializer(Class<?> vc) { 
        super(vc); 
    }

	@Override
	public Asset deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
		
		JsonNode jsonNode = p.getCodec().readTree(p);

		String className = setStringValue("className", jsonNode);
		String classNameReadable = setStringValue("classNameReadable", jsonNode);
		String id = setStringValue("id", jsonNode);
		boolean isPreferred = setBooleanValue("isPreferred", jsonNode);
		String label = setStringValue("label", jsonNode);
		Integer measurementCount = setIntValue("measurementCount", jsonNode);
		String shapeCategoryId = setStringValue("shapeCategoryId", jsonNode);
		
		Asset asset = new Asset(className, classNameReadable, id, isPreferred, label, measurementCount, shapeCategoryId);
		return asset;
	}
	
	private String setStringValue(String attribute, JsonNode jsonNode) {
		return Objects.nonNull(jsonNode.get(attribute)) ? jsonNode.get(attribute).get("value").asText() : null;
	}
	
	private Integer setIntValue(String attribute, JsonNode jsonNode) {
		
		if(Objects.nonNull(jsonNode.get(attribute))) {
			return jsonNode.get(attribute).get("value").asInt();
		}
		return null;
	}
	
	private boolean setBooleanValue(String attribute, JsonNode jsonNode) {
		return Objects.nonNull(jsonNode.get(attribute)) ? jsonNode.get(attribute).get("value").asBoolean() : null;
	}

}
