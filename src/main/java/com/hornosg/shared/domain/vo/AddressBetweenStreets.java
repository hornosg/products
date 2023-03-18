package com.hornosg.shared.domain.vo;

import java.util.List;

public class AddressBetweenStreets {
    private final List<String> value;

    public AddressBetweenStreets(List<String> value)
    {
        this.value = value;
    }

    public List<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value != null ? "[" + value + "]" : null;
    }
}
