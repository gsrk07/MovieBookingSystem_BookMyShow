package com.scaler.BookMyShow.exceptions;

public class UserAlreadyPresentException extends RuntimeException{

    public UserAlreadyPresentException() {
        super();
    }

    public UserAlreadyPresentException(String message) {
        super(message);
    }

    public UserAlreadyPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyPresentException(Throwable cause) {
        super(cause);
    }

    protected UserAlreadyPresentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
