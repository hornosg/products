package com.hornosg.products.categories.infrastructure.persistence;

import com.hornosg.products.categories.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategorySpringDataRepository extends CrudRepository<Category, String> {
    List<Category> findByTenantId(String tenantId);
}
