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
![e98728cffe3432bd070035965984dfdf.png](evernotecid://86FCFC13-5A95-4BF6-8902-FA132DA8DD7F/appyinxiangcom/18568258/ENResource/p1831)

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
