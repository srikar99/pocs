package com.siemens.aps.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.siemens.aps.model.Asset;
import com.siemens.aps.model.ResultBindings;

@Service
public class OwlProcessor {
	
	@Autowired
	private ObjectMapper mapper;
	
	public void mapJson(String json) {
		
		try {
			var resultBinding = mapper.readValue(owlString(), ResultBindings.class);
			
			System.out.println(resultBinding);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	private String owlString() {
		
		return "{\"bindings\":[{\"owlClassIri\":{\"type\":\"uri\",\"value\":\"http://www.siemens.com/ontology/aps-plantmodel#BallValve\"},\"owlClassName\":{\"type\":\"literal\",\"value\":\"BallValve\"}},{\"owlClassIri\":{\"type\":\"uri\",\"value\":\"http://www.siemens.com/ontology/aps-plantmodel#ButterflyValve\"},\"owlClassName\":{\"type\":\"literal\",\"value\":\"ButterflyValve\"}},{\"owlClassIri\":{\"type\":\"uri\",\"value\":\"http://www.siemens.com/ontology/aps-plantmodel#CentrifugalPump\"},\"owlClassName\":{\"type\":\"literal\",\"value\":\"CentrifugalPump\"}}]}";
	}

}
