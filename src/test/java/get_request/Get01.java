package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*

    1-Postman manuel API testi icin kullanilir
    2-API otomasyon testi icin Rest-Assured Library kullaniyoruz
    3-Otomasyon kadlarinin yazimi icin su adimlari izliyoruz
     * Gereksinimleri anlama

     * Test Case'i yazma;
       i>Test case yazimi icin 'Gherkin Language' kullaniyoruz

      ii>Gherkin bazi keywordlere sahip, bunlar
         ->Given: On kosullar icin
         ->When: Aksiyonlar -- Get. Put
         ->Then: Ciktilar, Donutler --Dogrulama response
         ->And: Coklu islemler icin kullanilir

      iii> Testing kodunun yazimi
         ->Set the URL
         ->Set the expected data(POT-PUT-PATCH)
         ->Type code to send request
         ->Da Assertion (Dogrulama)

     */


    /*
     Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK

     */
    @Test
    public void get01(){

        // ->Set the URL
        String url="https://restful-booker.herokuapp.com/booking";

        // ->Set the expected data(POT-PUT-PATCH)

        // ->Type code to send request
        // get request yapmak icin asagidaki given kismini yapiyoruz
        Response response =given().when().get(url);

        response.prettyPrint();

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .statusLine("HTTP/1.1 200 OK");
        // ->Da Assertion



        //'Status Code' nasil yazdirilir
        System.out.println("statusCode " + response.statusCode());

        //'contentType' nasil yazdirilir
        System.out.println("contentType " + response.contentType());

        //'statusLine' nasil yazdirilir
        System.out.println("statusLine " + response.statusLine());


    }




}
