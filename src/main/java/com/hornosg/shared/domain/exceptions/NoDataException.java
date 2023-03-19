package com.hornosg.shared.domain.exceptions;

public class NoDataException extends DomainNotFoundException
{
    public static final String ERROR_MESSAGE = "The are no data.";

    public NoDataException(){
        super(ERROR_MESSAGE);
    }
}
