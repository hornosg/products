package com.hornosg.products.brands.application.read;

import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.domain.BrandDoesNotExistsException;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import com.hornosg.shared.domain.exceptions.NoDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandReader {

    @Autowired
    private BrandSpringDataRepository repository;

    public Brand invoke(String id){
        Optional<Brand> brand = repository.findById(id);
        if (brand.isEmpty()){
            throw new BrandDoesNotExistsException();
        }
        return brand.get();
    }

    public List<Brand> list(String tenantId){
        List<Brand> brands = (List<Brand>) repository.findByTenantId(tenantId);
        if (brands.size() == 0){
            throw new NoDataException();
        }
        return brands;
    }
}
