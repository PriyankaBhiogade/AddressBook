package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {

    //Created JSON file
    @Test
    public void givenFileName_WhenProper_ShouldReturnTrue() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.createFile("Maharashtra");
        Assert.assertTrue(result);
    }
    @Test
    public void givenFileName_WhenProperButAllReadyExits_ShouldReturnFalse() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.createFile("Maharashtra");
        Assert.assertFalse(result);
    }

    @Test
    public void givenFileName_WhenImProper_ShouldReturnFalse() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.createFile("");
        Assert.assertFalse(result);
    }

    //Add person details
    @Test
    public void givenPersonInfo_WhenProper_ShouldReturnTrueAndWriteIntoFile() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.addPersonData("Mr ram1","giri",1452361452,"lakhani","MH",441804);
        Assert.assertTrue(result);

    }

    @Test
    public void givenPersonInfo_WhenFiledEmpty_ShouldReturnFalse() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.addPersonData("","",0,"" ,"",0);
        Assert.assertFalse(result);
    }


    //EditMobileNum
    @Test
    public void givenFiledForEdit_WhenProperEdit_ReturnTrueAndSaveIntoJSon() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        try {
            Boolean result = addressBook.editPersonMobileNum(1234567890,12456);
            Assert.assertTrue(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFiledForEdit_WhenImProper_ReturnTrue() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        try {
            Boolean result = addressBook.editPersonMobileNum(123456,12456);
            Assert.assertFalse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EditAddress
    @Test
    public void givenFiledForAddressEdit_WhenProperEdit_ReturnTrueAndSaveIntoJSon() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();

        try {
            Boolean result = addressBook.editPersonAddress(12456,"nag", "MH",145236);
            Assert.assertFalse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFiledForAddressEdit_WhenImProperEdit_ReturnFalseAndSaveIntoJSon() {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        try {
            Boolean result = addressBook.editPersonAddress(1245,"nag", "MH",145236);
            Assert.assertFalse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //DeletePerson
    @Test
    public void givenMoNum_WhenProper_ReturnTrueAndDeleteFromJSon() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.deletePersonDetails(145278);
        Assert.assertTrue(result);
    }

    @Test
    public void givenMoNum_WhenImProper_ReturnFalse() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.deletePersonDetails(145236);
        Assert.assertFalse(result);
    }

    //SortByLastName
    @Test
    public void sortByLastName_WhenProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.sortByName();
        Assert.assertTrue(result);
    }

    //SortByZip
    @Test
    public void sortByZipCode_WhenProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.sortZipCode();
        Assert.assertTrue(result);
    }

    //PrintAddressBook
    @Test
    public void printAddressBook_WhenProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.printAddressBook();
        Assert.assertTrue(result);
    }
}


