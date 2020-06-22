package com.sritest.petstoreapi.cucumberSerenity;

import com.sritest.petstoreapi.enums.PetStatus;
import com.sritest.petstoreapi.services.Context;
import com.sritest.petstoreapi.services.IApiService;
import com.sritest.petstoreapi.services.ScenarioContext;
import com.sritest.petstoreapi.services.WiremockService;
import com.sritest.petstoreapi.utilities.PetUtilities;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import net.thucydides.core.annotations.Step;

@Log4j2
public class SerenityStepDef {

    @Autowired
    private PetUtilities petUtilities;

    @Autowired
    private ScenarioContext scenarioContext;

    @Autowired
    private WiremockService wiremockService;

    @Autowired
    private IApiService restfulApiService;

    @Step
    public void runningThisTestWithWiremockOptionSetTo(String wiremockFlag){
        scenarioContext.setContext(Context.WIREMOCK_FLAG,wiremockFlag);
    }

    @Step
    public void endPointUrlToPerformGetRequest(String endPointUrl){
        scenarioContext.setContext(Context.ENDPOINT_URL,endPointUrl);
    }

    @Step
    public void performTheGetRequestWithGivenParameters(String petStatus, String petName){
        scenarioContext.setContext(Context.PET_STATUS,petStatus);
        scenarioContext.setContext(Context.PET_NAME,petName);
    }

    @Step
    public void checkWhetherTheNumberOfPetsEqualsTheExpectedValue(int expectedValue){
        // determine the wiremock flag.
        // call the associated function.
        String mockingUrl = "/v2/pet/findByStatus";
        String endpointUrl = scenarioContext.getContext(Context.ENDPOINT_URL).toString();
        PetStatus petStatus = PetStatus.valueOf(scenarioContext.getContext(Context.PET_STATUS).toString());

        if(scenarioContext.getContext(Context.WIREMOCK_FLAG).toString().equalsIgnoreCase("true")){
            System.out.println(">>>>> Switch on wiremock service. <<<<<<<<<<");
            log.info(">>>>> Switch on wiremock service. <<<<<<<<<<");
            wiremockService.getWiremockResponse(mockingUrl);
            endpointUrl = "http://localhost:"+wiremockService.wiremockPort+mockingUrl;
        }
        else{
            endpointUrl = endpointUrl+"?status="+scenarioContext.getContext(Context.PET_STATUS);
        }
        Response response = restfulApiService.get(endpointUrl);
        System.out.println(response.prettyPrint());
        log.info(response.prettyPrint());

        long count =petUtilities.getPetsByStatus(response.asString(),petStatus,"doggie");
        System.out.println(">>>>>>> Count of pets: "+count);
        log.info(">>>>>>> Count of pets: "+count);
        Assertions.assertThat(count).as("The expected and actual values didn't match").isEqualTo((long)expectedValue);
    }



}
