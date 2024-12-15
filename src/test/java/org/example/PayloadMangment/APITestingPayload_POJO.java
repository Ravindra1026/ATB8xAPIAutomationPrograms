package org.example.PayloadMangment;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.PayloadMangment.gson.Booking;
import org.example.PayloadMangment.gson.BookingDates;
import org.testng.annotations.Test;

public class APITestingPayload_POJO {
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

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(booking).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingId = response.then().extract().path("bookingid");

        // Get Validatable response to perform validation

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        System.out.println("Your booking id is -> " + bookingId);
    }


}
