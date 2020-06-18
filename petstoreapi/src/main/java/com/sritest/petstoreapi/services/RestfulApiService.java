package com.sritest.petstoreapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@Service
public class RestfulApiService implements IApiService {

    @Autowired
    private ScenarioContext scenarioContext;

    private ContentType contentType;

    @Override
    public Response get(final String endpointUrl) {

        System.out.println(">>>>>>>> Performing Get Operation <<<<<<<");

        // check whether wiremock flag is On
        if(scenarioContext.getContext(Context.WIREMOCK_FLAG).toString().equalsIgnoreCase("true")){
            contentType = ContentType.TEXT;
        }
        else{
            contentType = ContentType.JSON;
        }
        //
        // Response response = given().
        //         contentType(contentType).
        //         accept(contentType).
        //         when().
        //         get(endpointUrl).
        //         then().extract().response();

        return given().
                contentType(contentType).
                accept(contentType).
                when().
                get(endpointUrl).
                then().
                statusCode(HttpStatus.OK.value())
                .contentType(contentType).extract().response();



    }
}

/*
String response = RestAssured
                .given()
                .contentType(ContentType.TEXT)
                .accept(ContentType.TEXT)
                .when()
                .get("http://localhost:8123/wiremocktest/hello")
                .then()
                //.time(greaterThan((long) DEFAULT_TIMEOUT))
                .statusCode(HttpStatus.OK.value())
                .contentType(ContentType.TEXT).extract().response().asString();
        System.out.println(">>>>>\n\n "+response);
 */