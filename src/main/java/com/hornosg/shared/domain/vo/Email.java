package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.exceptions.EmailInvalidException;
import com.hornosg.shared.domain.exceptions.EmailRequiredException;

import java.util.regex.Pattern;

public class Email extends StringDomainNotNull{

    public Email(String value) throws EmailRequiredException
    {
        super(value);
        if (!isValid(value)){
            throw new EmailInvalidException();
        }
    }

    private Boolean isValid(String value){
        String regexPattern = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
                + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regexPattern);
        return pattern.matcher(value).matches();
    }
}
