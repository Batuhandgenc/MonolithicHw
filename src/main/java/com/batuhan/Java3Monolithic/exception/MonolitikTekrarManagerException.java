package com.batuhan.Java3Monolithic.exception;

import lombok.Getter;

@Getter
public class MonolitikTekrarManagerException extends RuntimeException{
    private final Error error;

    public MonolitikTekrarManagerException(Error error) {
        super(error.getMessage());
        this.error= error;
    }
    public MonolitikTekrarManagerException(Error error , String errorMsg) {
        super(errorMsg);
        this.error = error;
    }
}
