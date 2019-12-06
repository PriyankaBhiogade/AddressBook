package com.addressbook;

import com.google.gson.Gson;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBookOperation {
    private List<PersonModel> personList = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();
    private String jsonPath;

    public List<PersonModel> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonModel> personList) {
        this.personList = personList;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String getJsonPath() {
        return jsonPath;
    }

    public void setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
    }

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
        if (firstName.length() == 0 && lastName.length() == 0 && city.length() == 0 && state.length() == 0 && moNo == 0 && zip == 0) {
            System.out.println("Invalid Input");
            return false;
        }
        AddressModel addressModel = new AddressModel();
        addressModel.setCity(city);
        addressModel.setState(state);
        addressModel.setZip(zip);

        PersonModel personModel = new PersonModel();
        personModel.setFirstName(firstName);
        personModel.setLastName(lastName);
        personModel.setPhoneNumber(moNo);
        personModel.setAddress(addressModel);

        this.personList.add(personModel);
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        addressBookMenu.saveAddressBook(this);
        return true;
    }

    public Boolean editPersonMobileNum(int moNO, int newMoNo) throws IOException {
        int index = -1;
        for (int i = 0; i < this.personList.size(); i++) {
            if (this.personList.get(i).getPhoneNumber() == moNO) {
                index = i;
                break;
            }
        }
        this.personList.get(index).setPhoneNumber(newMoNo);
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        addressBookMenu.saveAddressBook(this);
        return true;
    }

    public Boolean editPersonAddress(int moNO, String city, String state, int zip) throws IOException {
        int index = -1;
        for (int i = 0; i < this.personList.size(); i++) {
            if (this.personList.get(i).getPhoneNumber() == moNO) {
                index = i;
                break;
            }
        }
        this.personList.get(index).setAddress(new AddressModel(city, state, zip));
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        addressBookMenu.saveAddressBook(this);
        return true;
    }

    public Boolean deletePersonDetails(int moNO) throws IOException {
        int index = -1;
        for (int i = 0; i < this.personList.size(); i++) {
            if (this.personList.get(i).getPhoneNumber() == moNO) {
                index = i;
                break;
            }
        }
        this.personList.remove(index);
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        addressBookMenu.saveAddressBook(this);
        return true;
    }

    public Boolean sortByName() throws IOException {
        for (int i = 0; i < this.personList.size() - 1; i++) {
            for (int j = 0; j < this.personList.size() - i - 1; j++) {
                if (this.personList.get(j).getLastName().compareTo(this.personList.get(j + 1).getLastName()) > 0) {
                    PersonModel temp = this.personList.get(j);
                    this.personList.set(j,this.personList.get(j + 1));
                    this.personList.set(j + 1, temp);
                }
            }
        }
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        addressBookMenu.saveAddressBook(this);
        return true;
    }

    public Boolean sortZipCode() throws IOException {
        for (int i = 0; i < this.personList.size() - 1; i++) {
            for (int j = 0; j < this.personList.size() - i - 1; j++) {
                if (this.personList.get(j).getAddress().getZip() > (this.personList.get(j + 1).getAddress().getZip()) ) {
                    PersonModel temp = this.personList.get(j);
                    this.personList.set(j,this.personList.get(j + 1));
                    this.personList.set(j + 1, temp);
                }
            }
        }

        AddressBookMenu addressBookMenu = new AddressBookMenu();
        addressBookMenu.saveAddressBook(this);
        return true;
    }

    public Boolean printAddressBook() throws IOException {
        this.personList.forEach((record) -> System.out.println(record));
        return true;
    }

    public void read(String fileName) throws IOException {
         this.personList = objectMapper.readValue(new File("/home/admin1/Desktop/AddressBook/Maharashtra.json"), new TypeReference<List<PersonModel>>() {
        });
        this.jsonPath=fileName;
    }

    public void writeIntoJSON(List<PersonModel> personList,String filePath) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(personList);
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(json);
        fileWriter.close();
    }
}
