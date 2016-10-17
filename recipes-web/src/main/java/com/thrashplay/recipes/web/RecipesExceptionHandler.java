package com.thrashplay.recipes.web;

import com.thrashplay.recipes.controller.ValidationFailedException;
import com.thrashplay.recipes.model.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler
 *
 * @author Sean Kleinjung
 */
@ControllerAdvice
public class RecipesExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @ExceptionHandler({ ValidationFailedException.class })
    protected ResponseEntity<Object> handleInvalidRequest(RuntimeException e, WebRequest request) {
        ValidationFailedException exception = (ValidationFailedException) e;

        Result result = new Result();
        for (FieldError fieldError : exception.getErrors().getFieldErrors()) {
            String message = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            result.addError(fieldError.getField(), message);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return handleExceptionInternal(e, result, headers, HttpStatus.UNPROCESSABLE_ENTITY, request);
    }
}
