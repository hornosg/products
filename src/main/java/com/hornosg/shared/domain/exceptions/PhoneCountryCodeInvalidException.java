package com.hornosg.shared.domain.exceptions;

public class PhoneCountryCodeInvalidException extends IllegalArgumentException{
    public PhoneCountryCodeInvalidException(){
        super("Phone Country Code invalid");
    }
}
