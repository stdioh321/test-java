package com.stdioh321.sboot.exceptions;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class EntityValidationException extends RuntimeException {
    private String message = "Validation Error";
    private List<FieldError> errors = new ArrayList<>();

    public EntityValidationException(String message, List<FieldError> errors) {
        this.message = message;
        this.errors = errors;
    }

    public EntityValidationException(List<FieldError> errors) {
        this.errors = errors;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }
}
