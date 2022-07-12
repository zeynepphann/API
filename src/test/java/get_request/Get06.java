package get_request;

import base_Urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;

public class Get06 extends HerokuappBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking/101
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "GGS",
            "lastname": "FINCH",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2018-01-01",
                "checkout": "2019-01-01"
            }

        }
     */
    @Test
    public void get01(){
        //1. Step; Set the url
        spec.pathParams("first","booking","second",101);

        //2. Step; Set the expected data

        //3. Step; Send request and get the response

        Response response=given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();
        //4. Step;
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Sally"),
                        "lastname",equalTo("Brown"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2013-02-23"),
                        "bookingdates.checkout",equalTo("2014-10-23"));

        //2.Yol
        JsonPath jsonPath=response.jsonPath();
        assertEquals("Sally",jsonPath.getString("firstname"));
        //Bu sekilde devam eder

        //3.yol

        //1.SoftAssert Objesi olusturulur
        SoftAssert softAssert=new SoftAssert();

        //2.Obje araciligi ile assert yapilir
        softAssert.assertEquals(jsonPath.getString("firstname"), "Sally", "firstname uyusmadi");
       // Bu sekilde devam eder.




    }
}
