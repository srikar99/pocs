package com.siemens.aps.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@JsonDeserialize(using = AssetDeserializer.class)
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown=true)
@AllArgsConstructor
public class Asset {

	
	private String classNameVal;
	private String classNameReadableVal;
	private String idVal;
	private boolean isPreferredVal;
	private String labelVal;
	private Integer measurementCountVal;
	private String shapeCategoryIdVal;
	
	@JsonProperty("className")
	private void className(Map<String, Object> className) {
		this.classNameVal = (String) className.get("value");
	}
	
	@JsonProperty("classNameReadable")
	private void classNameReadable(Map<String, Object> className) {
		this.classNameReadableVal = (String) className.get("value");
	}
	
	@JsonProperty("id")
	private void id(Map<String, Object> className) {
		this.idVal = (String) className.get("value");
	}
	
	@JsonProperty("isPreferred")
	private void isPreferred(Map<String, Object> className) {
		this.isPreferredVal = Boolean.parseBoolean((String) className.get("value"));
	}
	
	@JsonProperty("label")
	private void label(Map<String, Object> className) {
		this.labelVal = (String) className.get("value");
	}
	
	@JsonProperty("measurementCount")
	private void measurementCount(Map<String, Object> className) {
		this.measurementCountVal = Integer.parseInt((String) className.get("value"));
	}
	
	@JsonProperty("shapeCategoryId")
	private void shapeCategoryId(Map<String, Object> className) {
		this.shapeCategoryIdVal = (String) className.get("value");
	}
}
