package com.hornosg.products.brands.application.delete;

import com.hornosg.products.brands.application.read.BrandReader;
import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandRemover {

    @Autowired
    private BrandReader reader;
    @Autowired
    private BrandSpringDataRepository repository;

    public void invoke(String id){
        Brand brand = reader.invoke(id);
        repository.deleteById(id);
    }

}
