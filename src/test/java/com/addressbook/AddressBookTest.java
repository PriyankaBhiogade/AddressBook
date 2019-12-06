package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
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

    @Test
    public void givenPersonInfo_WhenProper_ShouldReturnTrueAndWriteIntoFile() throws IOException {
        AddressBookAnalyser addressBook = new AddressBookAnalyser();
        Boolean result = addressBook.addPersonData("ram","giri",1234567890,"lakhani","MH",441804);
        Assert.assertTrue(result);

    }

}


