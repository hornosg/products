package com.hornosg.products.categories.application.create;

import jakarta.validation.constraints.NotEmpty;

public class NewCategoryCommand {

    public String parentId;

    @NotEmpty
    public String name;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
