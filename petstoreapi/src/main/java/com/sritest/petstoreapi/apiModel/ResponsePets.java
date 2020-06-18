package com.sritest.petstoreapi.apiModel;

import java.util.List;

import lombok.Data;

@Data
public class ResponsePets {

    private long id;

    private Category category;

    private String name;

    private List<String> photoUrls;

    private List<Tags> tags;

    private String status;


}

@Data
class Category{
    private int id;
    private String name;
}

@Data
class Tags{
    private int id;
    private String name;

}
