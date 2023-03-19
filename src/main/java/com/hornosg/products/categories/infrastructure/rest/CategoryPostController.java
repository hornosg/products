package com.hornosg.products.categories.infrastructure.rest;

import com.hornosg.products.categories.application.create.CategoryCreator;
import com.hornosg.products.categories.application.create.NewCategoryCommand;
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

import java.util.Map;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class CategoryPostController extends BaseController{

    @Autowired
    private CategoryCreator creator;

    @PostMapping("/v1/category")
    public ResponseEntity<?> createBrand(
            @Valid @RequestBody NewCategoryCommand requestBody,
            BindingResult result
    ) {
        Map<String, String> errors = hasErrors(result);
        if (errors != null) return ResponseEntity.badRequest().body(errors);

        creator.invoke(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
