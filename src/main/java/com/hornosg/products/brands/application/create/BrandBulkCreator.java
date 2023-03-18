package com.hornosg.products.brands.application.create;

import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandBulkCreator {

    @Autowired
    private BrandSpringDataRepository repository;

    public void invoke(NewBrandsCommand brands){
        brands.getBrands().forEach( brandName -> {
            repository.save(new Brand(UUID.randomUUID().toString(), brandName));
        });
    }




}
