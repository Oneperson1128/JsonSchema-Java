import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.Test;

import javax.xml.bind.ValidationException;
import java.io.InputStream;

public class testJson {
    @Test
    public void testJsonSchema3() throws ValidationException {
        InputStream inputStream = getClass().getResourceAsStream("/Schema.json");
        JSONObject Schema = new JSONObject(new JSONTokener(inputStream));
        JSONObject data = new JSONObject("{\"foo\" : '2342'}");
        org.everit.json.schema.Schema schema = SchemaLoader.load(Schema);
        ((org.everit.json.schema.Schema) schema).validate(data);
    }
}
