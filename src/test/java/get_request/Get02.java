package get_request;

import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {
/*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found (statusLine)
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */
    @Test
    public void get01(){
        //1. Step; Set theUrl
        String url= "https://restful-booker.herokuapp.com/booking/10001";

        //2. Step; Set the expected data (Post -Put -Patch) body'e ihtiyac var

        //3.Step; Type code to send  request
        Response response =given().when().get(url);
        response.prettyPrint();

        //4. Do Assertions
        // assertThat kiyasla, oldugunu kontrol et
        response.then().assertThat()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found");

        //response body'de bulunan spesifik bir veri nasil assert edilir.
        //assertTrue() methodu parantezin icindeki deger true ise testi gecirir
        assertTrue(response.asString().contains("Not Found"));

        assertFalse(response.asString().contains("TechProEd"));

        assertEquals("Cowboy",response.header("Server"));



    }

}
