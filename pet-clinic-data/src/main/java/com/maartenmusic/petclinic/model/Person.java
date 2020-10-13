package com.maartenmusic.petclinic.model;

public class Person extends BaseEntity {

    // === fields ===

    private String firstName;
    private String lastName;

    // == constructors ===


    // === getters setters ===


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
