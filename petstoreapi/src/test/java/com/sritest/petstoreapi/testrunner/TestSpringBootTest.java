package com.sritest.petstoreapi.testrunner;

import com.sritest.petstoreapi.enums.PetStatus;
import com.sritest.petstoreapi.utilities.PetUtilities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration(exclude={ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class TestSpringBootTest {

    @Autowired
    private PetUtilities petUtilities;

    @Test
    public void runATest(){
        String endpointUrl = "https://petstore.swagger.io/v2/pet/findByStatus?status=available";

        // int num = petUtilities.getPetsByStatus(PetStatus.petstatus_available,"doggie",endpointUrl);
        // System.out.println("Pet Nos. : "+num);




    }

}
