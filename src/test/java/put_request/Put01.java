package put_request;

import base_Urls.JsonplaceholderBaseUrls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonplaceholderBaseUrls {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void Put01(){

        //1. Step: Set the Url

        spec.pathParams("first","todos","second",198);

        //2. Step: Set the expected Data
        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedDataMap =expectedData.expectedDataWithAllKeys(21,"Wash the dishes",false);

        //3. Step: Send the Put Request get the Response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().put("/{first}/{second}");
        response.prettyPrint();

        //4. Step: Do Assertion
        Map<String,Object> actualDataMap = response.as(HashMap.class);

        assertEquals(expectedDataMap.get("userId"), actualDataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"), actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"), actualDataMap.get("completed"));

    }
}
