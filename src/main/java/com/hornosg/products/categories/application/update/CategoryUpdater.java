package com.hornosg.products.categories.application.update;

import com.hornosg.products.categories.application.read.CategoryReader;
import com.hornosg.products.categories.domain.Category;
import com.hornosg.products.categories.domain.CategoryDoesNotExistsException;
import com.hornosg.products.categories.infrastructure.persistence.CategorySpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryUpdater {
    private static final Logger LOG = LoggerFactory.getLogger(CategoryUpdater.class);

    @Autowired
    private CategoryReader reader;
    @Autowired
    private CategorySpringDataRepository repository;

    public void invoke(String id, UpdateCategoryCommand command) throws InterruptedException {
        Category category = reader.invoke(id);
        repository.save(
                new Category(
                        id,
                        command.tenantId,
                        command.parentId,
                        command.name
                )
        );

        if (categoryNameChanged(category.getName(), command.name)){
            updateProductCategoryName(id, command.name);
        }
    }

    private boolean categoryNameChanged(String currentName, String newName){
        return !currentName.equals(newName);
    }

    @Async("threadPoolExecutor")
    private void updateProductCategoryName(String id, String name) throws InterruptedException {
        Thread.sleep(1000L);
        //TODO: Call to UC
        LOG.info("...Actualizo la Categoria en los Productos!");
    }

}
