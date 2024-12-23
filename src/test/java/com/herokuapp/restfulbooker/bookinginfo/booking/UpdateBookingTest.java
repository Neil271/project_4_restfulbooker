package com.herokuapp.restfulbooker.bookinginfo.booking;

import com.herokuapp.restfulbooker.model.UserPojo;
import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdateBookingTest extends TestBase {
   @Test
    public void updateBooking(){
       String checkInDate = "2018-01-01";
       String checkOutDate = "2019-01-01";

       Map<String, String> booking = new HashMap<>();
       booking.put("checkin", checkInDate);
       booking.put("checkout", checkOutDate);

       UserPojo userPojo = new UserPojo();
       userPojo.setUsername("admin24535");
       userPojo.setPassword("password123");
       userPojo.setFirstname("ooo");
       userPojo.setLastname("iii");
       userPojo.setTotalprice(110);
       userPojo.setDepositpaid(false);
       userPojo.setCheckin(checkInDate);
       userPojo.setCheckout(checkOutDate);
       userPojo.setAdditionalneeds("Breakfast");
       userPojo.setBookingdates(booking);


        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept","application/json")
                .header("cookie","token=ee90bdee7973e66")
                .pathParam("id",2960)
                .when()
                .body(userPojo)
                .put("/booking/{id}");
        response.prettyPrint();
        response.then().statusCode(200);
    }
}
