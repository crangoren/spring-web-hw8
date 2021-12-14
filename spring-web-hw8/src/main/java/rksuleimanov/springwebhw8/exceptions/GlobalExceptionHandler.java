package rksuleimanov.springwebhw8.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<rksuleimanov.springwebhw8.exceptions.AppError> catchResourceNotFoundException(rksuleimanov.springwebhw8.exceptions.ResourceNotFoundException  e) {
        return new ResponseEntity<>(new rksuleimanov.springwebhw8.exceptions.AppError (HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
