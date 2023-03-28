package com.hornosg.products.brands.application.update;

import com.hornosg.products.brands.application.read.BrandReader;
import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.domain.BrandDoesNotExistsException;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandUpdater {
    private static final Logger LOG = LoggerFactory.getLogger(BrandUpdater.class);

    @Autowired
    private BrandReader reader;

    @Autowired
    private BrandSpringDataRepository repository;

    public void invoke(String id, UpdateBrandCommand command) throws InterruptedException {
        Brand brand = reader.invoke(id);
        repository.save(
                new Brand(
                        id,
                        command.tenantId,
                        command.name
                )
        );
        if (brandNameChanged(brand.getName(), command.name)){
            updateProductBrandName(id, command.name);
        }
    }

    private boolean brandNameChanged(String currentName, String newName){
        return !currentName.equals(newName);
    }

    @Async("threadPoolExecutor")
    private void updateProductBrandName(String id, String name) throws InterruptedException {
        Thread.sleep(1000L);
        //TODO: Call to UC
        LOG.info("...Actualizo la Categoria en los Productos!");
    }
}
