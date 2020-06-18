package com.sritest.petstoreapi.cucumberSerenity;

import com.sritest.petstoreapi.AbstractTest;
import com.sritest.petstoreapi.services.WiremockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@EnableAutoConfiguration(exclude={ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class CucumberStepDef extends AbstractTest {


    //@Steps
    @Autowired
    private SerenityStepDef serenityStepDef;
    @Autowired
    private WiremockService wiremockService;

    @After
    public void afterTest(){
        wiremockService.stopWiremock();
    }

    @Given("^As a client application with wiremock option set to \"([^\"]*)\"$")
    public void asAClientApplicationWithWiremockOptionSetTo(String wiremockFlag)  {
        serenityStepDef.runningThisTestWithWiremockOptionSetTo(wiremockFlag);
    }

    @When("^I perform a Get request to the endpoint \"([^\"]*)\"$")
    public void iPerformAGetRequestToTheEndpoint(String endpointUrl)  {
        serenityStepDef.endPointUrlToPerformGetRequest(endpointUrl);
    }

    @And("^query for the status as \"([^\"]*)\" with pet name as \"([^\"]*)\"$")
    public void queryForTheStatusAsWithPetNameAs(String petStatus, String petName)  {
        serenityStepDef.performTheGetRequestWithGivenParameters(petStatus,petName);

    }

    @Then("^the number of pets from the response should be equal to an expected value of (\\d+)$")
    public void theNumberOfPetsFromTheResponseShouldBeEqualToAnExpectedValueOf(int expectedNoOfPets) {
        serenityStepDef.checkWhetherTheNumberOfPetsEqualsTheExpectedValue(expectedNoOfPets);
    }
}

