package com.addressbook;

import sun.jvm.hotspot.debugger.Address;

public class AddressBookModel {

    String firstName;
    String lastName;
    Address address;
    int phoneNumber;


    public AddressBookModel(String firstName, String lastName, Address address ,int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public AddressBookModel() {

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

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public Address getAddress()
    {
        return address;
    }
    public void setAddress(Address address) {

        address = address;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
