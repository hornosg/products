package com.hornosg.products.brands.infrastructure.persistence;

import com.hornosg.products.brands.domain.Brand;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface BrandSpringDataRepository extends CrudRepository<Brand, UUID> {}
