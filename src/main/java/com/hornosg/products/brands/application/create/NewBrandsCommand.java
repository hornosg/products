package com.hornosg.products.brands.application.create;

import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class NewBrandsCommand {

    @NotEmpty
    public String tenantId;

    @NotEmpty
    public List<String> brands;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public List<String> getBrands() {
        return brands;
    }

    public void setBrands(List<String> brands) {
        this.brands = brands;
    }
}
