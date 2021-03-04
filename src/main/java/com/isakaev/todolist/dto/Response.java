package com.isakaev.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Объект Response
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {

    /**
     * Сообщение
     */
    private String message;
}
