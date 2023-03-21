package com.hornosg.products.brands.application.create;

import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BrandCreator {

    @Autowired
    private BrandSpringDataRepository repository;

    public void invoke(NewBrandCommand command){
        repository.save(
                new Brand(
                        UUID.randomUUID().toString(),
                        command.tenantId,
                        command.name
                )
        );
    }

}
