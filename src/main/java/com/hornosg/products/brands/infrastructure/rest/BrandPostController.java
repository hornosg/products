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
public class BrandPostController {

    @Autowired
    private BrandCreator creator;

    @Autowired
    private BrandBulkCreator bulkCreator;

    @PostMapping("/v1/brand")
    public ResponseEntity<?> createBrand(
            @Valid @RequestBody NewBrandCommand requestBody,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach( error -> {
                errors.put(
                        error.getField(),
                        String.format("%s %s", error.getField(), error.getDefaultMessage())
                );
            });
            return ResponseEntity.badRequest().body(errors);
        }

        creator.invoke(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/v1/brands")
    public ResponseEntity<?> createBrands(
            @Valid @RequestBody NewBrandsCommand requestBody,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach( error -> {
                errors.put(
                        error.getField(),
                        String.format("%s %s", error.getField(), error.getDefaultMessage())
                );
            });
            return ResponseEntity.badRequest().body(errors);
        }

        bulkCreator.invoke(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
