package com.hornosg.products.brands.domain;

import com.hornosg.shared.domain.exceptions.DomainNotFoundException;

public class BrandDoesNotExistsException extends DomainNotFoundException
{
    public static final String ERROR_MESSAGE = "Brand does not exists";

    public BrandDoesNotExistsException(){
        super(ERROR_MESSAGE);
    }
}
