package com.sritest.petstoreapi.testrunner;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.junit.Before;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WireMockExampleTest {

    @Before
    public void setUP(){

        RestAssured.reset();
        RestAssured.port = 8123;

    }


    @Test
    public void sampleWiremock() {

        WireMockServer mWireMockServer = new WireMockServer(8123);
        mWireMockServer.start();

        mWireMockServer.stubFor(
                get(urlEqualTo("/wiremocktest/hello"))
                        .withHeader(HttpHeaders.ACCEPT, equalTo(MediaType.TEXT_PLAIN_VALUE))
                        .willReturn(
                                aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, "text/plain")
                                        .withBody("Hello client, this is the response body.")
                                //.withFixedDelay(DEFAULT_TIMEOUT * 2)
                        )
        );

        /* Send the test-request. */
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
        System.out.println(">>>>> Wiremock response:\n\n "+response);

        mWireMockServer.stop();

    }


}
