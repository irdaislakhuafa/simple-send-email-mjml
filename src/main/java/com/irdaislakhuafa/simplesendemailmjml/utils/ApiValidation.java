package com.irdaislakhuafa.simplesendemailmjml.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.validation.Errors;

public class ApiValidation {
    public static final Map<?, ?> getErrorMessage(Errors errors) {
        var errorMessage = new HashMap<>();
        for (var err : errors.getFieldErrors()) {
            errorMessage.put(err.getField(), err.getDefaultMessage());
        }
        return errorMessage;
    }
}
