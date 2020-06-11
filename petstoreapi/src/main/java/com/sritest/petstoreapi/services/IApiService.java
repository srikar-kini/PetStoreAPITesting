package com.sritest.petstoreapi.services;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface IApiService {

    String get(String endpointUrl);

}
