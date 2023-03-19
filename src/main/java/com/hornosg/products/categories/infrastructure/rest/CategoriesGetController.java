package com.hornosg.products.categories.infrastructure.rest;

import com.hornosg.products.categories.application.read.CategoryReader;
import com.hornosg.shared.infrastructure.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class CategoriesGetController extends BaseController{

    @Autowired
    private CategoryReader reader;

    @GetMapping("/v1/category/{id}")
    public ResponseEntity<?> readBrand(@PathVariable String id) {
        return ResponseEntity.ok(reader.invoke(id));
    }

    @GetMapping("/v1/categories")
    public ResponseEntity<?> listBrands() {
        return ResponseEntity.ok(reader.list());
    }
}
