package com.hornosg.shared.infrastructure;

import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    public static final String BASE_URI = "hornosg";
    public static final String MESSAGE_REQUEST_WITHOUT_BODY = "Request body does not empty";
    protected Boolean emptyBody(Map<String, Object> requestBody) {
        return requestBody.isEmpty();
    }

    protected static Map<String, String> hasErrors(BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> {
                errors.put(
                        error.getField(),
                        String.format("%s %s", error.getField(), error.getDefaultMessage())
                );
            });
            return errors;
        }
        return null;
    }
}