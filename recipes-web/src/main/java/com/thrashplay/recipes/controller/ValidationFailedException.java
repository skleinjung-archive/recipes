package com.thrashplay.recipes.controller;

import org.springframework.validation.Errors;

/**
 * Exception type thrown by a controller when data validation fails.
 *
 * @author Sean Kleinjung
 */
public class ValidationFailedException extends RuntimeException {
    private String globalMessage;
    private Errors errors;

    public ValidationFailedException(String globalMessage, Errors errors) {
        super(globalMessage);
        this.globalMessage = globalMessage;
        this.errors = errors;
    }

    public String getGlobalMessage() {
        return globalMessage;
    }

    public Errors getErrors() {
        return errors;
    }
}
