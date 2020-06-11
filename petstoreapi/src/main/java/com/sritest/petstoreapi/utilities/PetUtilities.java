package com.sritest.petstoreapi.utilities;

import com.sritest.petstoreapi.enums.PetStatus;
import com.sritest.petstoreapi.services.IApiService;
import com.sritest.petstoreapi.services.RestfulApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class PetUtilities {

    @Qualifier("restfulApiService")
    @Autowired
    IApiService apiService;

    public PetUtilities(RestfulApiService apiService) {
        this.apiService = apiService;
    }

    public int getPetsByStatus(PetStatus petStatus, String petName, String endpointUrl){
        System.out.println("..>> entering PetUtilities");
        String response = apiService.get(endpointUrl);
        System.out.println("\n\n"+response+"\n\n");


        return 100;
    }

}
