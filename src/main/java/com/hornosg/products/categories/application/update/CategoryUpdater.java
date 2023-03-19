package com.hornosg.products.categories.application.update;

import com.hornosg.products.categories.domain.Category;
import com.hornosg.products.categories.infrastructure.persistence.CategorySpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryUpdater {

    @Autowired
    private CategorySpringDataRepository repository;

    public void invoke(String id, UpdateCategoryCommand command){
        repository.save(new Category(id, command.parentId, command.name));
    }

}
