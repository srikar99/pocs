package com.siemens.aps.odata.mustache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;
import com.siemens.aps.odata.processor.JsonProcessor;

public class PojoGenerator {

	JsonProcessor jsonProcessor = new JsonProcessor();

	public void setContext() {
		var className = "Positioner";
		Context context = new Context();
		context.setClassname(className);
		context.setPackages("com.siemens.aps.odata.model;");
		List<Context.Property> properties = new ArrayList<Context.Property>();
		try {
			properties = jsonProcessor.processJson();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		context.setProperties(properties);

		String content = generatePojo(context, "templates/pojo.mustache");

		generateFile(className, content);

	}

	public String generatePojo(Object context, String template) {
		try {
			StringWriter writer = new StringWriter();
			MustacheFactory mf = new DefaultMustacheFactory();
			Mustache mustache = mf.compile(template);
			mustache.execute(writer, context).flush();
			return writer.toString();
		} catch (Exception ex) {
			System.out.println();
		}

		return "";
	}

	public static void generateFile(String className, String content) {
		System.out.println("GENERATING " + className);
		System.out.println("COntent:######" + content);
		try {

			File file = new File(
					"D:\\practice_workspace\\mustache-template-example\\src\\main\\java\\com\\siemens\\aps\\odata\\model");
			file.mkdir();
			File file1 = new File(file.getAbsolutePath() + "\\" + className + ".java");
			file1.createNewFile();
			FileOutputStream outputStream = new FileOutputStream(file1);
		    byte[] strToBytes = content.getBytes();
		    outputStream.write(strToBytes);

		    outputStream.close();
		} catch (IOException e) {
			System.out.println("Error generating file" + e);
		}
	}

	public static String camelCase(String word) {
		String[] chars = word.split("");
		Boolean upper = false;
		String results = "";
		for (String c : chars) {
			if (!"_".equals(c)) {
				results += upper ? c.toUpperCase() : c;
				upper = false;
			} else {
				upper = true;
			}
		}
		return results;
	}
}
