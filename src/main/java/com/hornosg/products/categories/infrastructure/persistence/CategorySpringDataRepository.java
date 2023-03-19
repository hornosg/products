package com.hornosg.products.categories.infrastructure.persistence;

import com.hornosg.products.categories.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategorySpringDataRepository extends CrudRepository<Category, String> {}
