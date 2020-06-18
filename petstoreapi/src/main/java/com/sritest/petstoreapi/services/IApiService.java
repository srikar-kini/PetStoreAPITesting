package com.sritest.petstoreapi.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.restassured.response.Response;

public interface IApiService {

    Response get(String endpointUrl);

}
