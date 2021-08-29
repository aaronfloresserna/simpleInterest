/*
 * Aaron Flores
 * Aplazo project
 * 29, Agosto 2021
 */

package com.api.SimpleInterest.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e){
        //Payload containing exception details
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(
            e.getMessage(),
            badRequest.value(),
            badRequest,
            ZonedDateTime.now()
        );

        return new ResponseEntity<>(apiException, badRequest);
    }
}
