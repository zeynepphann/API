package post_requests;

import base_Urls.HerokuappBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post04Pojo extends HerokuappBaseUrl {
     /*
         Given
          1)  https://restful-booker.herokuapp.com/booking
          2)   {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
          I send POST Request to the URL
       Then
          Status code is 200
      And
          Response body is like {
                                  "bookingid": 16,
                                  "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                        "additionalneeds": "Breakfast with white tea, Dragon juice"
                                     }
                                  }
     */
    @Test
    public void PostPojo01(){
        spec.pathParam("first","booking");

        BookingDatesPojo bookingdates=new BookingDatesPojo("2021-09-21","2021-12-21");
        BookingPojo bookingPojo= new BookingPojo("Ali","Can",999, true,bookingdates,"Breakfast with white tea, Dragon juice");

        Response response= given().spec(spec).contentType(ContentType.JSON).body(bookingPojo).when().post("/{first}"); // booking hepsini barindirir

        BookingResponseBodyPojo actualPojo= response.as(BookingResponseBodyPojo.class); // response'i pojoya cevirme = deseleration

        assertEquals(200,response.getStatusCode());
        response.prettyPrint();
        assertEquals(bookingPojo.getFirstname(),actualPojo.getBooking().getFirstname());
        assertEquals(bookingPojo.getLastname(),actualPojo.getBooking().getLastname());
        assertEquals(bookingPojo.getTotalprice(),actualPojo.getBooking().getTotalprice());
        assertEquals(bookingPojo.getDepositpaid(),actualPojo.getBooking().getDepositpaid());


        //1.yol
        assertEquals(bookingPojo.getBookingdates().getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingPojo.getBookingdates().getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(bookingPojo.getAdditinalneeds(),actualPojo.getBooking().getAdditinalneeds());

        //2.yol
        assertEquals(bookingdates.getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(bookingdates.getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());



    }




}
