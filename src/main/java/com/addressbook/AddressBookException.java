package com.addressbook;

public class AddressBookException extends Exception{
    enum ExceptionType {
        NO_SUCH_FILE
    }

    ExceptionType type;

    public AddressBookException(ExceptionType type, String message, String e) {
        super(message);
        this.type = type;
    }
}
