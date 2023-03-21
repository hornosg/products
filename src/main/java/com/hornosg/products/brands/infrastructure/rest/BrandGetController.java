package com.hornosg.products.brands.infrastructure.rest;

import com.hornosg.products.brands.application.read.BrandReader;
import com.hornosg.shared.infrastructure.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class BrandGetController extends BaseController{

    @Autowired
    private BrandReader reader;

    @GetMapping("/v1/brand/{id}")
    public ResponseEntity<?> readBrand(@PathVariable String id) {
        return ResponseEntity.ok(reader.invoke(id));
    }

    @GetMapping("/v1/brands/{tenantId}")
    public ResponseEntity<?> listBrands(@PathVariable String tenantId) {

        return ResponseEntity.ok(reader.list(tenantId));
    }
}
