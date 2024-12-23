package com.herokuapp.restfulbooker.bookinginfo.booking;

import com.herokuapp.restfulbooker.model.UserPojo;
import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PartialUpdateTest extends TestBase {

    @Test
    public void UpdateOneRecord() {
        String checkInDate = "2019-01-01";
        String checkOutDate = "2020-01-01";

        Map<String, String> booking = new HashMap<>();
        booking.put("checkin", checkInDate);
        booking.put("checkout", checkOutDate);

        UserPojo userPojo = new UserPojo();
        userPojo.setUsername("admin24535");
        userPojo.setPassword("password123");
        userPojo.setFirstname("ooo");
        userPojo.setLastname("xxx");
        userPojo.setTotalprice(100);
        userPojo.setDepositpaid(true);
        userPojo.setCheckin(checkInDate);
        userPojo.setCheckout(checkOutDate);
        userPojo.setAdditionalneeds("Breakfast");
        userPojo.setBookingdates(booking);


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("cookie","token=ac74ab649335ecc")
                .pathParam("id",2321)
                .when()
                .body(userPojo)
                .patch("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
