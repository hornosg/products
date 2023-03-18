package com.hornosg.shared.domain.vo;

import com.hornosg.shared.domain.Utils;

public class StringDomainNotNull extends StringDomain{

    public StringDomainNotNull(String value)
    {
        super(value);
        if (Utils.isNullString(value)){
            throw new NullPointerException();
        }
    }

}
