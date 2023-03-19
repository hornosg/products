package com.hornosg.products.categories.domain;

import com.hornosg.shared.domain.exceptions.DomainNotFoundException;

public class CategoryDoesNotExistsException extends DomainNotFoundException
{
    public static final String ERROR_MESSAGE = "Brand does not exists";

    public CategoryDoesNotExistsException(){
        super(ERROR_MESSAGE);
    }
}
