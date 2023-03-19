package com.hornosg.products.brands.infrastructure.rest;

import com.hornosg.products.brands.application.create.BrandBulkCreator;
import com.hornosg.products.brands.application.create.BrandCreator;
import com.hornosg.products.brands.application.create.NewBrandCommand;
import com.hornosg.products.brands.application.create.NewBrandsCommand;
import com.hornosg.shared.infrastructure.BaseController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class BrandPostController extends BaseController{

    @Autowired
    private BrandCreator creator;

    @Autowired
    private BrandBulkCreator bulkCreator;

    @PostMapping("/v1/brand")
    public ResponseEntity<?> createBrand(
            @Valid @RequestBody NewBrandCommand requestBody,
            BindingResult result
    ) {
        Map<String, String> errors = hasErrors(result);
        if (errors != null) return ResponseEntity.badRequest().body(errors);

        creator.invoke(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/v1/brands")
    public ResponseEntity<?> createBrands(
            @Valid @RequestBody NewBrandsCommand requestBody,
            BindingResult result
    ) {
        Map<String, String> errors = hasErrors(result);
        if (errors != null) return ResponseEntity.badRequest().body(errors);

        bulkCreator.invoke(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
