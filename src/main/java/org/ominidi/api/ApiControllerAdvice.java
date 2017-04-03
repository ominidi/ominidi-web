package org.ominidi.api;

import org.ominidi.api.exception.ConnectionException;
import org.ominidi.api.exception.NotFoundException;
import org.ominidi.api.model.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiControllerAdvice {
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Message> handleNotFoundException(NotFoundException e) {
        Message error = new Message(HttpStatus.NOT_FOUND.value(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ConnectionException.class)
    public ResponseEntity<Message> handleConnectionException(ConnectionException e) {
        Message error = new Message(HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
