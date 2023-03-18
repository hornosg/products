package com.hornosg.products.brands.application.create;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class NewBrandsCommand {

    @NotEmpty
    public List<String> brands;

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }
}
