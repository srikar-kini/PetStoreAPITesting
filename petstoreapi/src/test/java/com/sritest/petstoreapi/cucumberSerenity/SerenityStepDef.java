package com.sritest.petstoreapi.cucumberSerenity;

import com.sritest.petstoreapi.enums.PetStatus;
import com.sritest.petstoreapi.services.RestfulApiService;
import com.sritest.petstoreapi.utilities.PetUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import net.thucydides.core.annotations.Step;

public class SerenityStepDef {

    @Autowired
    PetUtilities petUtilities;


    @Step
    public void runTheTestWithWiremockOptionSetTo(String wiremockFlag){

    }

    @Step
    public void performGetRequest(String endpointUrl){
        System.out.println(">>> entering serenity step def");
        int num = petUtilities.getPetsByStatus(PetStatus.petstatus_available,"doggie",endpointUrl);
        System.out.println("Pet Nos. : "+num);
    }

}
