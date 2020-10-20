package com.job.prepareJob.model;

public class Information {
    private String street;
    private String city;
    private String state;
    private String zipcode;

    public Information(String street, String city, String state, String zipcode){
        this.city = city;
        this.state = state;
        this.street = street;
        this.zipcode = zipcode;
    }
    public Information(){}

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
