package com.hornosg.products.brands.application.update;

import jakarta.validation.constraints.NotEmpty;

public class UpdateBrandCommand {

    @NotEmpty
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
