package com.dugauguez.crunch.backend.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * BadRequestionException object used for returning a HTTP 400 error (extends of a throwable exception)
 */
@Getter
@Setter
@ResponseStatus(HttpStatus.BAD_REQUEST)
@ApiModel(description = "BadRequestionException object used for returning a HTTP 400 error (extends of a throwable exception)")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BadRequestException extends RuntimeException {

    @ApiModelProperty(value = "API error code")
    private final String error;
    @ApiModelProperty(value = "API error message")
    private final String message;

    /**
     * Build a new BadRequestException object
     * @param error error code
     * @param message error message
     */
    public BadRequestException(String error, String message) {
        this.error = error;
        this.message = message;

    }

}
