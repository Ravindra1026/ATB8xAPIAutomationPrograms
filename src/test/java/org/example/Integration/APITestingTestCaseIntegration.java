package org.example.Integration;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestingTestCaseIntegration {
    // Create token
    // Create a booking
    // Perform a put request
    // Verify that put is success by GET Request
    // Delete the ID
    // Verify it doesn't exist GET request
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String token;
    String bookingID;
    public String getToken(){
        return null;
    }
    public String getBookingID(){
        return null;
    }

    @Test
    public void test_update_request_put(){


    }

    @Test
    public void test_update_request_get(){

    }

}
