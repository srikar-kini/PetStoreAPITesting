package com.sritest.petstoreapi.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ScenarioContext {

    private Map<String, Object> scenarioContextMap = new HashMap<>();

    public void setContext(final Context key, final Object value) {
        scenarioContextMap.put(key.toString(), value);
    }

    public Object getContext(final Context key){
        return scenarioContextMap.get(key.toString());
    }

    public Boolean isContains(final Context key){
        return scenarioContextMap.containsKey(key.toString());
    }

}
