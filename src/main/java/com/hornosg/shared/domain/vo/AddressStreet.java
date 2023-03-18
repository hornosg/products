package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.exceptions.AddressStreetRequiredException;

public class AddressStreet extends StringDomainNotNull{

    public AddressStreet(String value) throws AddressStreetRequiredException
    {
        super(value);
    }
}
