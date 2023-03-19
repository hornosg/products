package com.hornosg.products.categories.infrastructure.rest;

import com.hornosg.products.categories.application.update.CategoryUpdater;
import com.hornosg.products.categories.application.update.UpdateCategoryCommand;
import com.hornosg.shared.infrastructure.BaseController;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(BaseController.BASE_URI)
public class CategoryPutController extends BaseController {

    @Autowired
    private CategoryUpdater updater;

    @PutMapping("/v1/category/{id}")
    public ResponseEntity<?> createBrand(
            @PathVariable String id,
            @Valid @RequestBody UpdateCategoryCommand requestBody,
            BindingResult result
    ) {
        Map<String, String> errors = hasErrors(result);
        if (errors != null) return ResponseEntity.badRequest().body(errors);

        updater.invoke(id, requestBody);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
