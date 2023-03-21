package com.hornosg.products.categories.application.create;

import com.hornosg.products.categories.domain.Category;
import com.hornosg.products.categories.infrastructure.persistence.CategorySpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryCreator {

    @Autowired
    private CategorySpringDataRepository repository;

    public void invoke(NewCategoryCommand command){
        repository.save(
                new Category(
                    UUID.randomUUID().toString(),
                    command.tenantId,
                    command.parentId,
                    command.name
                )
        );
    }

}
