package com.hornosg.products.brands.infrastructure.persistence;

import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.categories.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BrandSpringDataRepository extends CrudRepository<Brand, String> {
    List<Brand> findByTenantId(String tenantId);
}
