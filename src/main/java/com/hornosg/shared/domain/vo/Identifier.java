package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.exceptions.IdentifierInvalidException;

import java.util.UUID;

public class Identifier {
    private String value;

    public Identifier(){
        this.value = UUID.randomUUID().toString();
    }

    public Identifier(String value){
        this.value = value;
        if (!isValidUUID(value)){
            throw new IdentifierInvalidException();
        }
    }

    public String getValue() {
        return value;
    }

    protected Boolean isValidUUID(String value)
    {
        try {
            UUID.fromString(value);
        }catch (IllegalArgumentException e){

            return false;
        }

        return true;
    }
}
