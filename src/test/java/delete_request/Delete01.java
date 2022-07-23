package delete_request;

import base_Urls.JsonplaceholderBaseUrls;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Delete01 extends JsonplaceholderBaseUrls {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
                Status code is 200
         And Response body is { }
     */
    @Test
    public void delete01(){
        spec.pathParams("first","todos","second",2736);
        Map<String ,Object> expectedDataMap=new HashMap<>();
        Response response=given().spec(spec).when().delete("/{first}/{second}");

        //1.yol
        Map<String ,Object> actualMap= response.as(HashMap.class);
        response.then().assertThat().statusCode(200);
        assertEquals(actualMap,expectedDataMap);

        //2.yol
        assertTrue(actualMap.size()==0);
        assertTrue(actualMap.isEmpty());//tavsiye edilen

        // Delete request yapmadan once "POST REQUEST" yapip o datayi silmeliyiz








    }
}
