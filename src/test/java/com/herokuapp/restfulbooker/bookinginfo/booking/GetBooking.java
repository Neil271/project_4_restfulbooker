package com.herokuapp.restfulbooker.bookinginfo.booking;

import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetBooking extends TestBase {

    @Test
    public void getAllBookingsIds() {
        Response response = given()
                .header("Content-Type", "application/json")
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getBookingById() {
        Response response = given()
                .header("Content-Type", "application/json")
                .pathParam("id", 680)
                .when()
                .get("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getBookingByFirstNameAndLastName() {

        Map<String, String> map = new HashMap<>();
        map.put("firstname", "Jane");
        map.put("lastname", "Doe");

        Response response = given()
                .header("Content-Type", "application/json")
                .queryParams(map)
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }

    @Test
    public void getBookingByCheckInAndCheckOut() {

        Map<String, String> date = new HashMap<>();
        date.put("checkin", "2018-01-01");
        date.put("checkout", "2019-01-01");
        
        Response response = given()
                .header("Content-Type", "application/json")
                .queryParams(date)
                .when()
                .get("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
        //System.out.println(response.jsonPath());
    }
}
