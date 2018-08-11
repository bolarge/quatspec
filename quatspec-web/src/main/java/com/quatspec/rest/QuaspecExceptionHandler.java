package com.quatspec.rest;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.quatspec.api.exception.QuaspecError;
import com.quatspec.api.exception.QuaspecServiceException;
import com.quatspec.rest.model.ErrorResource;
import com.quatspec.rest.model.FieldErrorResource;

/**
 * Exception handler for rest endpoints
 */
@ControllerAdvice
public class QuaspecExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handles service exceptions
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({QuaspecServiceException.class})
    protected ResponseEntity<Object> handleServiceException(RuntimeException e, WebRequest request) {

       QuaspecError error = ((QuaspecServiceException) e).getError();

        HttpStatus httpStatus = HttpStatus.valueOf(error.getCode());
        if (httpStatus == null) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, httpStatus, request);
    }


    /**
     * Handles validation exceptions
     *
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler({QuaspecValidationException.class})
    protected ResponseEntity<Object> handleValidationException(RuntimeException e, WebRequest request) {

        QuaspecValidationException valEx = (QuaspecValidationException) e;
        ErrorResource error = valEx.getErrorResource();

        if (error == null) {
            List<FieldErrorResource> fieldErrorResources = new ArrayList<>();

            List<FieldError> fieldErrors = valEx.getErrors().getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                FieldErrorResource fieldErrorResource = new FieldErrorResource();
                fieldErrorResource.setResource(fieldError.getObjectName());
                fieldErrorResource.setField(fieldError.getField());
                fieldErrorResource.setCode(fieldError.getCode());
                fieldErrorResource.setMessage(fieldError.getDefaultMessage());
                fieldErrorResources.add(fieldErrorResource);
            }

            error = new ErrorResource(valEx.getMessage());
            error.setFieldErrors(fieldErrorResources);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, error, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
