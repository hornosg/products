package com.hornosg.shared.domain.exceptions;

public class EmailRequiredException extends IllegalArgumentException
{
    public static final String ERROR_MESSAGE = "Email is Required";

    public EmailRequiredException(){
        super(ERROR_MESSAGE);
    }
}
