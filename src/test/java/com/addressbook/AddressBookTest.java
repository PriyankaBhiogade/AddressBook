package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {

    //Created JSON file
    @Test
    public void givenFileName_WhenProper_ShouldReturnTrue() {
        AddressBookOperation addressBook = new AddressBookOperation();
        Boolean result = addressBook.createFile("Maharashtra");
        Assert.assertTrue(result);
    }
    @Test
    public void givenFileName_WhenProperButAllReadyExits_ShouldReturnFalse() {
        AddressBookOperation addressBook = new AddressBookOperation();
        Boolean result = addressBook.createFile("Maharashtra");
        Assert.assertFalse(result);
    }

    @Test
    public void givenFileName_WhenImProper_ShouldReturnFalse() {
        AddressBookOperation addressBook = new AddressBookOperation();
        Boolean result = addressBook.createFile("");
        Assert.assertFalse(result);
    }

    //Add person details
    @Test
    public void givenPersonInfo_WhenProper_ShouldReturnTrueAndWriteIntoFile() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.addPersonData("Mr ram112345","giri",1452361452,"lakhani","MH",441804);
        Assert.assertTrue(result);

    }

    @Test
    public void givenPersonInfo_WhenFiledEmpty_ShouldReturnFalse() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.addPersonData("","",0,"" ,"",0);
        Assert.assertFalse(result);
    }


    //EditMobileNum
    @Test
    public void givenFiledForEdit_WhenProperEdit_ReturnTrueAndSaveIntoJSon() {
        try {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
            Boolean result = addressBook.editPersonMobileNum(741236,1425369874);
            Assert.assertTrue(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFiledForEdit_WhenImProper_ReturnTrue() {
        try {
            AddressBookMenu addressBookMenu = new AddressBookMenu();
            AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
            Boolean result = addressBook.editPersonMobileNum(123456,12456);
            Assert.assertFalse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //EditAddress
    @Test
    public void givenFiledForAddressEdit_WhenProperEdit_ReturnTrueAndSaveIntoJSon() {
        try {
            AddressBookMenu addressBookMenu = new AddressBookMenu();
            AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
            Boolean result = addressBook.editPersonAddress(1452361452,"naaaag", "MH",145236);
            Assert.assertTrue(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenFiledForAddressEdit_WhenImProperEdit_ReturnFalseAndSaveIntoJSon() {
        try {
            AddressBookMenu addressBookMenu = new AddressBookMenu();
            AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
            Boolean result = addressBook.editPersonAddress(1245,"nag", "MH",145236);
            Assert.assertFalse(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //DeletePerson
    @Test
    public void givenMoNum_WhenProper_ReturnTrueAndDeleteFromJSon() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.deletePersonDetails(1425369874);
        Assert.assertTrue(result);
    }

    @Test
    public void givenMoNum_WhenImProper_ReturnFalse() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.deletePersonDetails(145236);
        Assert.assertFalse(result);
    }

    //SortByLastName
    @Test
    public void sortByLastName_WhenProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.sortByName();
        Assert.assertTrue(result);
    }

    @Test
    public void sortByLastName_WhenImProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("");
        Boolean result = addressBook.sortByName();
        Assert.assertTrue(result);
    }

    //SortByZip
    @Test
    public void sortByZipCode_WhenProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.sortZipCode();
        Assert.assertTrue(result);
    }

    @Test
    public void sortByZipCode_WhenImProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("");
        Boolean result = addressBook.sortZipCode();
        Assert.assertTrue(result);
    }

    //PrintAddressBook
    @Test
    public void printAddressBook_WhenProper_ReturnTrueAndSortByName() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation addressBook = addressBookMenu.openAddressBook("Maharashtra");
        Boolean result = addressBook.printAddressBook();
        Assert.assertTrue(result);
    }

    //OpenAddressBook
    @Test
    public void openAddressBook_WhenProper_ReturnTrueAndShow() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation result = addressBookMenu.openAddressBook("Maharashtra");
        Assert.assertTrue(result instanceof AddressBookOperation);

    }

    @Test
    public void openAddressBook_WhenImProperFileName_ReturnFalse() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation result = addressBookMenu.openAddressBook("maha");
        Assert.assertEquals(null,result);
    }

    //SaveAddressBook
    @Test
    public void saveAddressBook_WhenProper_ReturnTrue() throws IOException {
        AddressBookMenu addressBookMenu = new AddressBookMenu();
        AddressBookOperation object = addressBookMenu.openAddressBook("Maharashtra");
        addressBookMenu.saveAddressBook(object);
    }

}


