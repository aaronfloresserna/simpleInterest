/*
 * Aaron Flores
 * Aplazo project
 * 29, Agosto 2021
 */

package com.api.SimpleInterest.exceptions;

public class ApiRequestException extends  RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
