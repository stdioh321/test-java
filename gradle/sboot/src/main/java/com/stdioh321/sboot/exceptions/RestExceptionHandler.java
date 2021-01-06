package com.stdioh321.sboot.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler({EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(
            EntityNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND,
                ex.getMessage(), ex);
        return new ResponseEntity(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({EntityValidationException.class})
    protected ResponseEntity<Object> handleEntityValidationError(
            EntityValidationException ex) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,
                ex.getMessage(), ex);
        List<ApiSubError> tmp = ex.getErrors().stream().map(objectError -> {
            ApiValidationError subError = new ApiValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
            subError.setField(objectError.getField());
            subError.setRejectedValue(objectError.getRejectedValue());
            return subError;
        }).collect(Collectors.toList());
        apiError.setSubErrors(tmp);
        return new ResponseEntity(apiError, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({Exception.class})
    protected ResponseEntity handleGenericException(Exception ex){
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"Internal Server Error", ex);
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(ex.getClass().getName());
        System.out.println(ex.getMessage());
        System.out.println(ex.getLocalizedMessage());
        System.out.println("---------------------------------------------------------------------------");
        return new ResponseEntity(apiError, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
