package com.isakaev.todolist.service.exception;

public class NotFoundRecordException extends NullPointerException {
    public NotFoundRecordException(String s) {
        super(s);
    }
}
