package post_requests;

import base_Urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import testData.HerOkuAppTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Post02 extends HerokuappBaseUrl {
     /*
        Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2021-09-09",
                                                        "checkout": "2021-09-21"
                                                    }
                                                }
                                             }
     */

    @Test

    public void post02(){

        spec.pathParam("first","booking");
        HerOkuAppTestData herokuapp=new HerOkuAppTestData();
        Map<String,String> bookingdatesMap=herokuapp.bookingdatesSetUp("2021-09-09","2021-09-21");
        Map<String ,Object> expectedDataMap= herokuapp.expectedDataSetUp("John","Doe",11111,true,bookingdatesMap);

       Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{first}");
       response.prettyPrint();

       Map<String,Object > actualDataMap=response.as(HashMap.class);

       assertEquals(200,response.getStatusCode());
       assertEquals(expectedDataMap.get("firstname"),((Map)actualDataMap.get("booking")).get("firstname"));
       assertEquals(expectedDataMap.get("lastname"),((Map)actualDataMap.get("booking")).get("lastname"));
       assertEquals(expectedDataMap.get("totalprice"),((Map)actualDataMap.get("booking")).get("totalprice"));
       assertEquals(expectedDataMap.get("depositpaid"),((Map)actualDataMap.get("booking")).get("depositpaid"));

       assertEquals(bookingdatesMap.get("checkin"),((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
       assertEquals(bookingdatesMap.get("checkout"),((Map)((Map)actualDataMap.get("booking")).get("bookingdates")).get("checkout"));


    }

}
