package com.hornosg.shared.domain.exceptions;

public class PhoneAreaCodeInvalidException extends IllegalArgumentException{
    public PhoneAreaCodeInvalidException(){
        super("Phone Area Code invalid");
    }
}
