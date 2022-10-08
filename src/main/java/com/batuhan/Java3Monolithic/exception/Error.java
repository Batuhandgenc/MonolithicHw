package com.batuhan.Java3Monolithic.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum Error {
    USER_NOT_CREATED(80,"404 User is can't sign in", INTERNAL_SERVER_ERROR),
    USER_NOT_FOUND(81,"404 User is not found",INTERNAL_SERVER_ERROR);
    private int code;
    private String message;
    HttpStatus httpStatus;

}
