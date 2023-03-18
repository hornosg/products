package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.exceptions.PhoneNumberInvalidException;

public class PhoneCountryCode extends IntegerDomain{

    public PhoneCountryCode(Integer value)
    {
        super(value);
        if (!isValid(value)){
            throw new PhoneNumberInvalidException();
        }
    }

    private Boolean isValid(Integer value){
        return value > 9 && value < 9999;
    }
}
