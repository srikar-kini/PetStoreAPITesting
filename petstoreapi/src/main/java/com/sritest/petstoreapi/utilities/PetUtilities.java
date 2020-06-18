package com.sritest.petstoreapi.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sritest.petstoreapi.apiModel.ResponsePets;
import com.sritest.petstoreapi.enums.PetStatus;
import com.sritest.petstoreapi.services.IApiService;
import com.sritest.petstoreapi.services.RestfulApiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PetUtilities {


    @Autowired
    IApiService restfulApiService;

    private static Path path = Paths.get("");

    private static final Type RESPONSEPETS_TYPE = new TypeToken<List<ResponsePets>>() {}.getType();

    public String readJsonFromFile(String filename){
        String jsonString = "";
        try {
            File fileObj = new File(path.toAbsolutePath().toString()+filename);
            Scanner scanner = new Scanner(fileObj);
            while (scanner.hasNextLine()) {
                jsonString += scanner.nextLine();
            }
            scanner.close();
            return jsonString;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }



    public long getPetsByStatus(String jsonResponse, PetStatus petStatus, String petName){

        Gson gson = new Gson();
        List<ResponsePets> data = gson.fromJson(jsonResponse, RESPONSEPETS_TYPE);
        long count = data.stream().filter(d -> d.getName().equalsIgnoreCase(petName) && d.getStatus().equalsIgnoreCase(petStatus.getPetStatus())).count();

        return count;
    }

}
