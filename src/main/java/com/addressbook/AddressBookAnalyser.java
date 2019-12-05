package com.addressbook;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddressBookAnalyser {
    String firstName;
    String lastName;
    String Address;
    String city;
    String state;
    int zip;
    int phoneNumber;
    private static String GSON_FILE="AddressBook.json";
    private String name;

    public AddressBookAnalyser(String firstName, String lastName, String address, String city, String state, int zip, int phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
    }

    public AddressBookAnalyser() {

    }

    public static String addPerson(AddressBookModel book) throws IOException {
        convertCSVtoJSON(book);
        return null ;
    }
    public static void convertCSVtoJSON( AddressBookModel book) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(book);
        FileWriter fileWriter = new FileWriter(GSON_FILE);
        fileWriter.write(json);
        fileWriter.close();
    }

    public String createJSONFile( String name) {
        if (new File("/home/admin1/eclipse-workspace/BridgeLabzPrograms/src/com/bridgelabz/files/" + name + ".json") .exists()) 
        { 
            System.out.println("Address Book Already Exists");
        } 
        else {
            try {
            mapper.writeValue(new File( "/home/admin1/eclipse-workspace/BridgeLabzPrograms/src/com/bridgelabz/files/" + name + ".json"), list); 
            this.name = name;
        } catch (IOException e) { e.printStackTrace(); } finally { System.out.println("Address Book Created"); } }
    }

    }
}
