package com.addressbook;

import sun.jvm.hotspot.debugger.Address;

public class PersonModel {
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private AddressModel address;

    public PersonModel() {

    }

    public PersonModel(String firstName, String lastName, int phoneNumber, AddressModel address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressModel getAddress() {
        return address;
    }

    public void setAddress(AddressModel address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address=" + address +
                '}';
    }
}
