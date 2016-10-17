package com.thrashplay.recipes.model;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO: Add class documentation
 *
 * @author Sean Kleinjung
 */
public class Result {
    public static final Result SUCCESSS = new Result(true);

    private boolean success;
    private Map<String, String> errors = new HashMap<String, String>();

    public Result() {
    }

    public Result(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }

    public void addError(String fieldName, String error) {
        errors.put(fieldName, error);
    }
}
