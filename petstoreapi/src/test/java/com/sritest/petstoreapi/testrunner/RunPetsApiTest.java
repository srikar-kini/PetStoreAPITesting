package com.sritest.petstoreapi.testrunner;

import com.sritest.petstoreapi.services.RestfulApiService;
import com.sritest.petstoreapi.utilities.PetUtilities;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/features/PetEnquiry.feature"},
        glue = {"com.sritest.petstoreapi"})
public class RunPetsApiTest {

}
