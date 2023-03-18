package com.hornosg.shared.domain.exceptions;

public class AddressNumberInvalidException extends IllegalArgumentException{
    public AddressNumberInvalidException(){
        super("Address Number cannot be zero");
    }
}
