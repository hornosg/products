package com.hornosg.products.brands.infrastructure.persistence;

import com.hornosg.products.brands.domain.Brand;
import org.springframework.data.repository.CrudRepository;

public interface BrandSpringDataRepository extends CrudRepository<Brand, String> {}
