package com.siemens.aps.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	JsonProcessor jsonProcessor;
	
	@GetMapping("/")
	public void get() {
		jsonProcessor.mapJson(null);
	}
}
