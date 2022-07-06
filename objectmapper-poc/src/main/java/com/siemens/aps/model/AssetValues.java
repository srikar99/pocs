package com.siemens.aps.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonIgnoreProperties(value = {"type", "datatype"})
@JsonInclude(value = Include.NON_NULL)
public class AssetValues {

	private String value;
	
	private String type;
	
	private String datatype;
}
