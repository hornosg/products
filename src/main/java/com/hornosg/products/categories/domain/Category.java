package com.hornosg.products.categories.domain;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "categories")
public class Category {

    @MongoId
    private String id;

    @NotEmpty
    public String tenantId;
    private String patentId;

    @Indexed(unique = true)
    private String name;

    public Category(String id, String tenantId, String patentId, String name) {
        this.id = id;
        this.tenantId = tenantId;
        this.patentId = patentId;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatentId() {
        return patentId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
