package com.addressbook;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AddressBookTest {
    @Test
    public void givenUserInput_WhenProper_ReturnTrue() throws IOException {
        AddressModel addressModel = new AddressModel("sadfas", "dsfads", 123456789);
        AddressBookModel book = new AddressBookModel("priyanka","bhio",addressModel,123456789);
        String data = AddressBookAnalyser.addPerson(book);
        Assert.assertEquals(null,data);
    }

    @Test
    public void givenFileName_WhenProper_createdJsonFile() {
        AddressBookAnalyser bookAnalyser = new AddressBookAnalyser();
        String fileName  =  bookAnalyser.createJSONFile("address");
    }
}
