package com.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookMenu {
    private AddressBookOperation addressBookOperation;

    public AddressBookOperation openAddressBook(String fileName) throws IOException {
        File folder = new File("/home/admin1/Desktop/AddressBook");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        if (new File("/home/admin1/Desktop/AddressBook/" + fileName + ".json")
                .exists()) {
            AddressBookOperation addressBookOperation = new AddressBookOperation();
            addressBookOperation.read("/home/admin1/Desktop/AddressBook/" + fileName + ".json");
            return addressBookOperation;
        }
        else{
            return null;
        }
    }

    public AddressBookOperation saveAddressBook(AddressBookOperation obj) throws IOException {
        obj.writeIntoJSON(obj.getPersonList(),obj.getJsonPath());
        return null;
    }
}