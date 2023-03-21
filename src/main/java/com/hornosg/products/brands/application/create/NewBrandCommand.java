package com.hornosg.products.brands.application.create;

import jakarta.validation.constraints.NotEmpty;

public class NewBrandCommand {

    @NotEmpty
    public String tenantId;

    @NotEmpty
    public String name;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
