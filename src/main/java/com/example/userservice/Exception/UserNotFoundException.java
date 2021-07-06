package com.example.userservice.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class UserNotFoundException extends Exception{
   public UserNotFoundException(String message){
       super(message);
   }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
