package com.example.managerapp.security.exeption;


import lombok.Data;

@Data
public class UsernameFoundInBaseDate extends RuntimeException{
    private String error;

    public UsernameFoundInBaseDate(String error) {
        this.error = error;
    }

    public UsernameFoundInBaseDate(String message, String error) {
        super(message);
        this.error = error;
    }

    public UsernameFoundInBaseDate(String message, Throwable cause, String error) {
        super(message, cause);
        this.error = error;
    }

    public UsernameFoundInBaseDate(Throwable cause, String error) {
        super(cause);
        this.error = error;
    }

    public UsernameFoundInBaseDate(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String error) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.error = error;
    }
}
