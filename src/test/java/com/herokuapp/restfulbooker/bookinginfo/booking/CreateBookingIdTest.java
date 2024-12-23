package com.herokuapp.restfulbooker.bookinginfo.booking;

import com.herokuapp.restfulbooker.model.UserPojo;
import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CreateBookingIdTest extends TestBase {

    @Test
    public void createBooking() {

        /*Date checkInDate = new Date(2018,01,01);
        Date checkOutDate = new Date(2019, 01,01);*/

        String checkInDate = "2019-01-01";
        String checkOutDate = "2020-01-01";

        Map<String, String> booking = new HashMap<>();
        booking.put("checkin", checkInDate);
        booking.put("checkout", checkOutDate);

        UserPojo userPojo = new UserPojo();
        userPojo.setUsername("admin24535");
        userPojo.setPassword("password123");
        userPojo.setFirstname("ppp");
        userPojo.setLastname("xxx");
        userPojo.setTotalprice(100);
        userPojo.setDepositpaid(true);
        userPojo.setCheckin(checkInDate);
        userPojo.setCheckout(checkOutDate);
        userPojo.setAdditionalneeds("Breakfast");
        userPojo.setBookingdates(booking);


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when()
                .body(userPojo)
                .post("/booking");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
