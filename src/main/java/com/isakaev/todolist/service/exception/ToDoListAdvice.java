package com.isakaev.todolist.service.exception;

import com.isakaev.todolist.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ToDoListAdvice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Response> handleException (NotFoundRecordException exception){

        Response response = new Response(exception.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
