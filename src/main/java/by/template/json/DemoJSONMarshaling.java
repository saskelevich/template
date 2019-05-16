package by.template.json;

import java.io.File;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemoJSONMarshaling {

    public static void main(final String[] args)
            throws JsonGenerationException, JsonMappingException, IOException {
        final JSONObject sampleObject = new JSONObject();
        sampleObject.put("name", "StackAbuser");
        sampleObject.put("age", 35);

        final JSONArray message = new JSONArray();
        message.add("Hey!");
        message.add("What's up!");
//output in console
        sampleObject.put("message", message);
        System.out.println(sampleObject.toJSONString());
//output in file
        final File file = new File("./resource/json/test_json.json");
        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, sampleObject);
    }
}
