package com.hornosg.products.categories.application.delete;

import com.hornosg.products.categories.application.read.CategoryReader;
import com.hornosg.products.categories.domain.Category;
import com.hornosg.products.categories.infrastructure.persistence.CategorySpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryRemover {

    @Autowired
    private CategoryReader reader;
    @Autowired
    private CategorySpringDataRepository repository;

    public void invoke(String id){
        Category category = reader.invoke(id);
        repository.deleteById(id);
    }

}
