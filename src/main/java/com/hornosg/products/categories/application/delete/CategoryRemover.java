package com.hornosg.products.categories.application.delete;

import com.hornosg.products.brands.application.delete.BrandRemover;
import com.hornosg.products.categories.application.read.CategoryReader;
import com.hornosg.products.categories.domain.Category;
import com.hornosg.products.categories.infrastructure.persistence.CategorySpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryRemover {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryRemover.class);

    @Autowired
    private CategoryReader reader;
    @Autowired
    private CategorySpringDataRepository repository;

    public void invoke(String id){
        Category category = reader.invoke(id);
        repository.deleteById(id);

        LOG.info("Category Deleted ( id={}, name={} )", category.getId(), category.getName());
    }

}
