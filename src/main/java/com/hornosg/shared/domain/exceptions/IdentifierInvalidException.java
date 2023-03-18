package com.hornosg.shared.domain.exceptions;

public class IdentifierInvalidException extends IllegalArgumentException
{
    public static final String ERROR_MESSAGE = "Identifier is invalid";

    public IdentifierInvalidException(){
        super(ERROR_MESSAGE);
    }
}
