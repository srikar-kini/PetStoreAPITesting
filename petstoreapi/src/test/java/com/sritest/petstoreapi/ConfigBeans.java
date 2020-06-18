package com.sritest.petstoreapi;

import com.sritest.petstoreapi.cucumberSerenity.SerenityStepDef;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {

    @Bean
    public SerenityStepDef getSerenityStepDef(){
        return new SerenityStepDef();
    }

}
