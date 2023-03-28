package com.hornosg.products.brands.application.delete;

import com.hornosg.products.brands.application.read.BrandReader;
import com.hornosg.products.brands.application.update.BrandUpdater;
import com.hornosg.products.brands.domain.Brand;
import com.hornosg.products.brands.infrastructure.persistence.BrandSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandRemover {
    private static final Logger LOG = LoggerFactory.getLogger(BrandRemover.class);

    @Autowired
    private BrandReader reader;
    @Autowired
    private BrandSpringDataRepository repository;

    public void invoke(String id){
        Brand brand = reader.invoke(id);
        repository.deleteById(id);

        LOG.info("Brand Deleted ( id={}, name={} )", brand.getId(), brand.getName());
    }

}
