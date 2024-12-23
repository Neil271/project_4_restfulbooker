package com.herokuapp.restfulbooker.bookinginfo.auth;

import com.herokuapp.restfulbooker.model.UserPojo;
import com.herokuapp.restfulbooker.testbase.TestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateToken extends TestBase {

    @Test
    public void createToken(){
        UserPojo userPojo=new UserPojo();
        userPojo.setUsername("admin");
        userPojo.setPassword("password123");

        Response response=given()
                .header("Content-Type","application/json")
                .when()
                .body(userPojo)
                .post("/auth");
        response.prettyPrint();
        response.then().statusCode(200);
    }

}
