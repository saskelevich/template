package by.template.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJSONUnmarshaling {

    public static void main(final String[] args)
            throws JsonGenerationException, JsonMappingException, IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final Person ben = mapper.readValue(new File("./resource/json/example.json"), Person.class);
        System.out.println("deserialization");
        System.out.println(ben);

        System.out.println("\nserialization:");
        mapper.writeValue(System.out, ben);
    }
}
