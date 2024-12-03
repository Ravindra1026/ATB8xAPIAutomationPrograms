package org.example.GET;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITestingNonBddStyle001 {

    static RequestSpecification r = RestAssured.given();

    @Severity(SeverityLevel.BLOCKER)
    @Description("TC1- NonBDDStyle Positive Testcase")
    @Test
    public void test_NonBDDStyleGet_positive(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/302012");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }
    @Severity(SeverityLevel.CRITICAL)
    @Description("TC2- NonBDDStyle Negative Testcase")
    @Test
    public void test_NonBDDStyleGet_negative(){

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/-11");
        r.when().log().all().get();
        r.then().log().all().statusCode(404);

    }
}
