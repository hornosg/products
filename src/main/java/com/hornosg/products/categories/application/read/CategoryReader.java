package com.hornosg.products.categories.application.read;

import com.hornosg.products.categories.domain.Category;
import com.hornosg.products.categories.domain.CategoryDoesNotExistsException;
import com.hornosg.products.categories.infrastructure.persistence.CategorySpringDataRepository;
import com.hornosg.shared.domain.exceptions.NoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryReader {

    @Autowired
    private CategorySpringDataRepository repository;

    public Category invoke(String id){
        Optional<Category> category = repository.findById(id);
        if (category.isEmpty()){
            throw new CategoryDoesNotExistsException();
        }
        return category.get();
    }

    public List<Category> list(String tenantId){
        List<Category> categories = repository.findByTenantId(tenantId);
        if (categories.size() == 0){
            throw new NoDataException();
        }
        return categories;
    }
}
