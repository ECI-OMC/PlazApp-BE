package com.eci.cosw.plazaap.model;

public class Profile {

    private int id;
    private String ownerEmail;
    private String description;

    public Profile(){

    }

    public Profile(String email){
        this.ownerEmail = email;
        this.description = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
