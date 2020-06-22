package com.sritest.petstoreapi;

import com.sritest.petstoreapi.services.ScenarioContext;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.serenitybdd.junit.spring.integration.SpringIntegrationMethodRule;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration(exclude={ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class AbstractTest {


    @Rule
    public SpringIntegrationMethodRule springMethodIntegration
            = new SpringIntegrationMethodRule();

    @Autowired
    public ScenarioContext scenarioContext;
}
