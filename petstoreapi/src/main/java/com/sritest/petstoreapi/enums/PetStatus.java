package com.sritest.petstoreapi.enums;

public enum PetStatus {

    petstatus_available("available"),
    petstatus_pending("pending"),
    petstatus_sold("sold");

    private String petStatus;

    PetStatus(final String petStatus) {
        this.petStatus = petStatus;
    }

    public String getPetStatus() {
        return petStatus;
    }
}
