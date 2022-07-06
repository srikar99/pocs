package com.siemens.aps.process;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.siemens.aps.model.OwlClass;

import java.io.IOException;

public class OwlClassDeserializer extends StdDeserializer<OwlClass> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OwlClassDeserializer() {
        this(null);
    }

    protected OwlClassDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public OwlClass deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {

        JsonNode jsonNode = p.getCodec().readTree(p);


        return new OwlClass();
    }
}
