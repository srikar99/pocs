package com.siemens.aps.odata.mustache;

import java.util.List;

import org.springframework.util.StringUtils;

public class Context {

	List<Property> properties;
    List<String> constants;
    String className;
    String serialVersionUID;
    String packages;


    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getClassname() {
        return className;
    }

    public void setClassname(String classname) {
        this.className = classname;
    }

    public String getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setSerialVersionUID(String serialVersionUID) {
        this.serialVersionUID = serialVersionUID;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public List<String> getConstants() {
        return constants;
    }

    public void setConstants(List<String> constants) {
        this.constants = constants;
    }

    public static class Property {
        String property;
        String camelcase;
        List<String> annotations;
        String type = "String";

        public Property(String property, List<String> annotations) {
            this.annotations = annotations;
            this.property = property;
            this.camelcase = StringUtils.capitalize(property);
        }

        public Property(String property, List<String> annotations, String type) {
            this.annotations = annotations;
            this.property = property;
            this.camelcase = StringUtils.capitalize(property);
            this.type = type;
        }
    }
}
