/*
 * Aaron Flores
 * Aplazo project
 * 29, Agosto 2021
 */

package com.api.SimpleInterest.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class ApiException {
    private final String message;
    private final int status;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;
    
    public ApiException(String message,
                        int status,  
                        HttpStatus httpStatus, 
                        ZonedDateTime timeStamp) {

        this.message = message;
        this.status = status;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public int getStatus() {
        return status;
    }

    
    
}
