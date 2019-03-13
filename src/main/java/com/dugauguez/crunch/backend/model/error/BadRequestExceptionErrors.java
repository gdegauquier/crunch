package com.dugauguez.crunch.backend.model.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * List of BadRequest (HTTP 400) error codes the API will be able to return
 */
public enum BadRequestExceptionErrors {

    ERROR_ACCESS_DENIED("REQUEST.ERROR.ACCESS.DENIED");

    private String message;

    private static final Logger log = LoggerFactory.getLogger(BadRequestExceptionErrors.class);

    BadRequestExceptionErrors(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

}
