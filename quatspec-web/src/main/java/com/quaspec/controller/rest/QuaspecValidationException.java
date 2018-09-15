package com.quaspec.controller.rest;

import org.springframework.validation.Errors;

import com.quaspec.controller.rest.model.ErrorResource;

/**
 * Used to throw form validation exceptions
 */
public class QuaspecValidationException extends RuntimeException {

    private Errors errors;

    private ErrorResource errorResource;

    public QuaspecValidationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public QuaspecValidationException(ErrorResource errorResource) {
        super(errorResource.getMessage());
        this.errorResource = errorResource;
    }

    public Errors getErrors() {
        return errors;
    }

    public ErrorResource getErrorResource() {
        return errorResource;
    }
}
