package com.hornosg.products.brands.application.update;

import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandUpdater {

    @Autowired
    private BrandSpringDataRepository repository;

    public void invoke(String brandId, UpdateBrandCommand command){
        repository.save(new Brand(brandId, command.name));
    }

}
