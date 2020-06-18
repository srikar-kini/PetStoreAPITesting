package com.sritest.petstoreapi.services;

import java.awt.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.sritest.petstoreapi.utilities.PetUtilities;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.apache.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import io.restassured.RestAssured;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class WiremockService {

    @Autowired
    private PetUtilities petUtilities;
    @Autowired
    private ScenarioContext scenarioContext;

    private WireMockServer mWireMockServer;

    private String responseBody="";

    public final int wiremockPort = 8123;


    public void getWiremockResponse(String mockingUrl){

        responseBody = petUtilities.readJsonFromFile("/src/test/resources/pets.json");

        RestAssured.reset();
        RestAssured.port = wiremockPort;

        mWireMockServer = new WireMockServer(wiremockPort);
        mWireMockServer.start();

        mWireMockServer.stubFor(
                get(urlEqualTo(mockingUrl))
                        .withHeader(HttpHeaders.ACCEPT, equalTo(MediaType.TEXT_PLAIN_VALUE))
                        .willReturn(
                                aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withHeader(HttpHeaders.CONTENT_TYPE, "text/plain")
                                        .withBody(responseBody)
                        )
        );

    }


    public void stopWiremock(){
        if(scenarioContext.getContext(Context.WIREMOCK_FLAG).toString().equalsIgnoreCase("true")) {
            log.info("Stopping the Wiremock server....");
            mWireMockServer.stop();
        }
    }


}
