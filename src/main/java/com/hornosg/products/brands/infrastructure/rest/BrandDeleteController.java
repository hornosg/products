package com.hornosg.products.brands.infrastructure.rest;

import com.hornosg.products.brands.application.delete.BrandRemover;
import com.hornosg.shared.infrastructure.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class BrandDeleteController extends BaseController{

    @Autowired
    private BrandRemover remover;

    @DeleteMapping("/v1/brand/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable String brandId) {
        remover.invoke(brandId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
