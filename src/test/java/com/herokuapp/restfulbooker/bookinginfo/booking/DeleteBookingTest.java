package com.herokuapp.restfulbooker.bookinginfo.booking;

import com.herokuapp.restfulbooker.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookingTest extends TestBase {

    @Test
    public void deleteTheBooking() {
        given().log().all()
                .pathParam("id", 250)
                .when()
                .delete("/booking/{id}")
                .then().log().all()
                .statusCode(204);

    }
}
