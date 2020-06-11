package com.sritest.petstoreapi.cucumberSerenity;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CucumberStepDef {


    @Steps
    SerenityStepDef serenityStepDef;

    @Given("^As a client application with wiremock option set to \"([^\"]*)\"$")
    public void asAClientApplicationWithWiremockOptionSetTo(String wiremockFlag)  {
        serenityStepDef.runTheTestWithWiremockOptionSetTo(wiremockFlag);
    }

    @When("^I perform a Get request to the endpoint \"([^\"]*)\"$")
    public void iPerformAGetRequestToTheEndpoint(String endpointUrl)  {
        System.out.println("Obtained endpointurl from feature file as : "+endpointUrl);
        serenityStepDef.performGetRequest(endpointUrl);
    }

    @And("^query for the status as \"([^\"]*)\" with pet name as \"([^\"]*)\"$")
    public void queryForTheStatusAsWithPetNameAs(String petStatus, String petName)  {

    }

    @Then("^the number of pets from the response should be equal to an expected value of (\\d+)$")
    public void theNumberOfPetsFromTheResponseShouldBeEqualToAnExpectedValueOf(int expectedNoOfPets) {

    }
}

