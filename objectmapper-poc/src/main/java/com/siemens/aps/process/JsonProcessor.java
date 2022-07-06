package com.siemens.aps.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siemens.aps.model.Asset;
import com.siemens.aps.model.ResultBindings;

@Service
public class JsonProcessor {

	@Autowired
	private ObjectMapper mapper;

	public void mapJson(String json) {
		mapper.setSerializationInclusion(Include.NON_NULL);
		
		try {
			var resultBinding = mapper.readValue(jsonArray(), ResultBindings.class);
			
			System.out.println(resultBinding);
			var asset = mapper.readValue(json(), Asset.class);
			var assetString = mapper.writeValueAsString(asset);
			System.out.println("Asset String: " + assetString);
			System.out.println(asset);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	public String json() {
		return "{\"className\":{\"value\":\"PipingNetworkSegment\",\"type\":\"literal\"},\"classNameReadable\":{\"value\":\"PipingNetworkSegment\",\"type\":\"literal\"},\"id\":{\"value\":\"http://www.siemens.com/ontology/aps-plantmodel#PipingNetworkSegment_A10_A10_A10_47126_S5\",\"type\":\"uri\"},\"isPreferred\":{\"value\":\"true\",\"type\":\"literal\",\"datatype\":\"http://www.w3.org/2001/XMLSchema#boolean\"},\"label\":{\"value\":\"PipingNetworkSegment_A10_A10_A10_47126_S5\",\"type\":\"literal\"},\"shapeCategoryId\":{\"value\":\"XMP_331\",\"type\":\"literal\"}}}";
	}
	
	public String jsonArray() {
		return "{\"assets\":[{\"className\":{\"value\":\"PipingNetworkSegment\",\"type\":\"literal\"},\"classNameReadable\":{\"value\":\"PipingNetworkSegment\",\"type\":\"literal\"},\"id\":{\"value\":\"http://www.siemens.com/ontology/aps-plantmodel#PipingNetworkSegment_A10_A10_A10_47126_S5\",\"type\":\"uri\"},\"isPreferred\":{\"value\":\"true\",\"type\":\"literal\",\"datatype\":\"http://www.w3.org/2001/XMLSchema#boolean\"},\"label\":{\"value\":\"PipingNetworkSegment_A10_A10_A10_47126_S5\",\"type\":\"literal\"},\"shapeCategoryId\":{\"value\":\"XMP_331\",\"type\":\"literal\"}},{\"className\":{\"value\":\"PipingNetworkSegment1\",\"type\":\"literal\"},\"classNameReadable\":{\"value\":\"PipingNetworkSegment1\",\"type\":\"literal\"},\"id\":{\"value\":\"http://www.siemens.com/ontology/aps-plantmodel#PipingNetworkSegment_A10_A10_A10_47126_S5\",\"type\":\"uri\"},\"isPreferred\":{\"value\":\"false\",\"type\":\"literal\",\"datatype\":\"http://www.w3.org/2001/XMLSchema#boolean\"},\"label\":{\"value\":\"PipingNetworkSegment_A10_A10_A10_47126_S5\",\"type\":\"literal\"},\"measurementCount\":{\"value\":\"1\",\"type\":\"literal\",\"datatype\":\"http://www.w3.org/2001/XMLSchema#integer\"},\"shapeCategoryId\":{\"value\":\"XMP_331\",\"type\":\"literal\"}}]}";
	}

}
