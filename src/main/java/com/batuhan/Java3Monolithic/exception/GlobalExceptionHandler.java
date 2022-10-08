package com.batuhan.Java3Monolithic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    @ResponseBody
    public ResponseEntity<String> handleRuntimeException(RuntimeException i) {
        return ResponseEntity.ok("Unexpected Error" + i.getMessage());
    }
    @ExceptionHandler(MonolitikTekrarManagerException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleCommentAppManagerException(MonolitikTekrarManagerException i) {
        Error error = i.getError();
        HttpStatus httpStatus = error.getHttpStatus();
        return new ResponseEntity<>(createError(error,i),httpStatus);
    }
    private ErrorMessage createError(Error error, Exception exception) {
        System.out.println("Error message : " + exception.getMessage());
        return ErrorMessage.builder()
                .code(error.getCode())
                .message(error.getMessage())
                .build();
    }
}
