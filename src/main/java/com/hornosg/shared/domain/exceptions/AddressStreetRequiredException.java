package com.hornosg.shared.domain.exceptions;

public class AddressStreetRequiredException extends IllegalArgumentException{
    public AddressStreetRequiredException(){
        super("Address Street is Required");
    }
}
