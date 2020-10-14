package com.maartenmusic.petclinic.model;

public class PetType extends BaseEntity {

    // === fields ===

    private String name;

    // === constructors ===

    // ===  getters & setters ===

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
