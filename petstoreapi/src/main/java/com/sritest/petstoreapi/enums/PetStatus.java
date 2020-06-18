package com.sritest.petstoreapi.enums;

public enum PetStatus {

    available("available"),
    pending("pending"),
    sold("sold");

    private String petStatus;

    PetStatus(final String petStatus) {
        this.petStatus = petStatus;
    }

    public String getPetStatus() {
        return petStatus;
    }
}
