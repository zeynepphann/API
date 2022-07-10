import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class Get03 extends BaseUrls{

      /*
      Given
          https://jsonplaceholder.typicode.com/todos/23
      When
          User send GET Request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response format should be "application/json"
      And
          "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
      And
          "completed" is false
      And
          "userId" is 2
   */

    @Test
    public void get01(){
        // 1.set the url
        // spec= "https://jsonplaceholder.typicode.com/"
        // first="todos"
        // ikinci string kisim 23
        spec.pathParams("first","todos","second","23");

       // 2. Step Set the expected data
       // 3.  Send the Request and get the Response
       Response response= given().spec(spec).when().get("/{first}/{second}");

        //4.Step Do Assertion
        response.then().
                assertThat().
                statusCode(200).
                contentType("application/json").
                body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
                body("completed",equalTo(false)).
                body("userId",equalTo(21));

        // ama birden fazla body kullanmak oop konsepte ters bu yuzden
        // body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit","completed",equalTo(false),"userId",equalTo(21)).
        // bu sekilde kulllanilmasi daha dogru

    }
}
