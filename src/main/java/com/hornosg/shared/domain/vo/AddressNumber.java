package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.exceptions.AddressNumberInvalidException;

public class AddressNumber extends IntegerDomain{

    public AddressNumber(Integer value)
    {
        super(value);
        if (isInvalid(value)){
            throw new AddressNumberInvalidException();
        }
    }

    private Boolean isInvalid(Integer value){
        return value <= 0;
    }
}
