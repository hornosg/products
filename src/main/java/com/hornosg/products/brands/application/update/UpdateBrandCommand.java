package com.hornosg.products.brands.application.update;

import jakarta.validation.constraints.NotEmpty;

public class UpdateBrandCommand {

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
