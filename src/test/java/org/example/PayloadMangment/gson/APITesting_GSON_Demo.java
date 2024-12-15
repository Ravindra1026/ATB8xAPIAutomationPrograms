package org.example.PayloadMangment.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.testng.Assert;
import static org.assertj.core.api.Assertions.*;

public class APITesting_GSON_Demo {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testPOSTReq() {

        Booking booking = new Booking();
        booking.setFirstname("Ravindra");
        booking.setLastname("Singh");
        booking.setTotalprice(113);
        booking.setDepositpaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2024-03-02");
        bookingDates.setCheckout("2024-03-04");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        Gson gson = new Gson();
        // object to JSON string (GSON)
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        // Get Validatable response to perform validation

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your booking id is -> " + bookingId);

        //string - object - De Ser
        BookingResponse bookingResponse = gson.fromJson(jsonStringBooking, BookingResponse.class);

        assertThat(bookingResponse.getBooking()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Ravindra").isNotNull().isNotEmpty();






    }
}