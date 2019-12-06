package com.addressbook;

public class AddressModel {
    String city;
    String state;
    int zip;

    public AddressModel() {
    }

    public AddressModel(String city, String state, int zip) {
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getCity(String city) {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState(String state) {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip(int zip) {
        return this.zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "AddressModel{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
