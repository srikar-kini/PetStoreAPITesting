package com.sritest.petstoreapi.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@Component
public class RestfulApiService implements IApiService {

    @Override
    public String get(final String endpointUrl) {

        System.out.println("...>>> Entering RestfulApiService class.");

        Response response = given().
                contentType(ContentType.JSON).
                when().
                get(endpointUrl).
                then().extract().response();
        return response.asString();


    }
}
