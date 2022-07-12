package get_request;

import base_Urls.JsonplaceholderBaseUrls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get07 extends JsonplaceholderBaseUrls {
     /*
        Given
              https://jsonplaceholder.typicode.com/todos
      When
          I send GET Request to the URL
      Then
          1)Status code is 200
          2)Print all ids greater than 190 on the console
            Assert that there are 10 ids greater than 190
          3)Print all userIds whose ids are less than 5 on the console
            Assert that the number of userIds whose ids are less than 5 is 4
          4)Print all titles whose ids are less than 5
            Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */
    @Test
    public void get01(){
        spec.pathParam("first","todos");

       Response response= given().spec(spec).when().get("/{first}");


       response.then().assertThat().statusCode(200);

        JsonPath jsonPath=response.jsonPath();
        List<Integer> ids=jsonPath.getList("findAll{it.id>190}.id");// Groovy Language =Java temelli bir programlama dili

        System.out.println(ids);
        assertEquals(10,ids.size());

        List <Integer> ids2= jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println(ids2);
        assertEquals(4,ids2.size());

        List <String> ids3= jsonPath.getList("findAll{it.id<5}.title");
        System.out.println(ids3);

        // Assert that "delectus aut autem" is one of the titles whose id is less than 5
        assertTrue(ids3.contains("delectus aut autem"));



    }


}
