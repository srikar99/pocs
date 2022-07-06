package com.siemens.aps.odata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.siemens.aps.odata.mustache.PojoGenerator;

@SpringBootApplication
public class MustacheTemplateExampleApplication {

	public static void main(String[] args) {
		
		PojoGenerator generator = new PojoGenerator();
		generator.setContext();
		
		//SpringApplication.run(MustacheTemplateExampleApplication.class, args);
	}

}
