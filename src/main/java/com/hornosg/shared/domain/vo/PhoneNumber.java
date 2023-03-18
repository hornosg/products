package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.exceptions.PhoneNumberInvalidException;

public class PhoneNumber extends IntegerDomain{

    public PhoneNumber(Integer value)
    {
        super(value);
        if (!isValid(value)){
            throw new PhoneNumberInvalidException();
        }
    }

    private Boolean isValid(Integer value){
        return value > 99999;
    }
}
