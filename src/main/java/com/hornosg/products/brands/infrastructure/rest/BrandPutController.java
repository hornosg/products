package com.hornosg.products.brands.infrastructure.rest;

import com.hornosg.products.brands.application.update.BrandUpdater;
import com.hornosg.products.brands.application.update.UpdateBrandCommand;
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
public class BrandPutController extends BaseController {

    @Autowired
    private BrandUpdater updater;

    @PutMapping("/v1/brand/{brandId}")
    public ResponseEntity<?> createBrand(
            @PathVariable String brandId,
            @Valid @RequestBody UpdateBrandCommand requestBody,
            BindingResult result
    ) {
        Map<String, String> errors = hasErrors(result);
        if (errors != null) return ResponseEntity.badRequest().body(errors);

        updater.invoke(brandId, requestBody);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
