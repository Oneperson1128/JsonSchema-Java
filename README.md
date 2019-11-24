# JsonSchema-Java
#### java实现校验
###### 1、pom.xml文件：
```
<dependency>
			<groupId>org.everit.json</groupId>
			<artifactId>org.everit.json.schema</artifactId>
			<version>1.3.0</version>
		</dependency>
```
###### 2.文件
failure.json ：   {"foo" : 1234}

Schema.json ：
{
  "type": "object",
  "properties" : {
    "foo" : {
      "type" : "string"
    }
  }
}
--放在根目录下即可

###### 3.测试代码
```
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

```
