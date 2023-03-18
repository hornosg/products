package com.hornosg.shared.domain.exceptions;

public class PhoneNumberInvalidException extends IllegalArgumentException{
    public PhoneNumberInvalidException(){
        super("Phone Number invalid");
    }
}
