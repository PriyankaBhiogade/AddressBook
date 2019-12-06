package com.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookMenu {
    public AddressBookAnalyser openAddressBook(String fileName) throws IOException {
        File folder = new File("/home/admin1/Desktop/AddressBook");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        if (new File("/home/admin1/Desktop/AddressBook/" + fileName + ".json")
                .exists()) {

            AddressBookAnalyser addressBookAnalyser = new AddressBookAnalyser();
            addressBookAnalyser.read("/home/admin1/Desktop/AddressBook/" + fileName + ".json");
            return addressBookAnalyser;
        }
        else{
            return null;
        }
    }
}