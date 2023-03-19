package com.hornosg.products.categories.infrastructure.rest;

import com.hornosg.products.categories.application.delete.CategoryRemover;
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
public class CategoryDeleteController extends BaseController{

    @Autowired
    private CategoryRemover remover;

    @DeleteMapping("/v1/category/{id}")
    public ResponseEntity<?> deleteBrand(@PathVariable String id) {
        remover.invoke(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
