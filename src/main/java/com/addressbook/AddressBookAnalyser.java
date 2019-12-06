package com.addressbook;

import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookAnalyser {
    List<PersonModel> personList = new ArrayList<>();
    ObjectMapper objectMapper = new ObjectMapper();
    private String jsonPath;

    public boolean createFile(String jsonPath) {
        if (jsonPath.length() == 0) {
            System.out.println("Invalid or empty FileName");
            return false;
        } else {
            if (new File("/home/admin1/Desktop/AddressBook/" + jsonPath + ".json")
                    .exists()) {
                System.out.println("Address Book Already Exists");
                return false;
            } else {
                try {
                    objectMapper.writeValue(new File("/home/admin1/Desktop/AddressBook/" + jsonPath + ".json"), personList);
                    this.jsonPath = jsonPath;

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                System.out.println("Address Book Created");
            }
        }
        return true;
    }

    public Boolean addPersonData(String firstName, String lastName, int moNo, String city, String state, int zip) throws IOException {
        AddressModel addressModel = new AddressModel();
        addressModel.setCity(city);
        addressModel.setState(state);
        addressModel.setZip(zip);

        PersonModel personModel = new PersonModel();
        personModel.setFirstName(firstName);
        personModel.setLastName(lastName);
        personModel.setPhoneNumber(moNo);
        personModel.setAddress(addressModel);

        PersonModel personAdd = new PersonModel(firstName, lastName, moNo, new AddressModel(city, state, zip));
        List<PersonModel> list = objectMapper.readValue(new File("/home/admin1/Desktop/AddressBook/Maharashtra.json"), new TypeReference<List<PersonModel>>(){});
        list.add(personAdd);
        this.writeIntoJSON(list);
        return true;
    }

    public static void writeIntoJSON(List<PersonModel> personList ) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(personList);
        FileWriter fileWriter = new FileWriter("/home/admin1/Desktop/AddressBook/Maharashtra.json");
        fileWriter.write(json);
        fileWriter.close();
    }

}
