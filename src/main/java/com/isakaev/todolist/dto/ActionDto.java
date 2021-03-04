package com.isakaev.todolist.dto;

import com.isakaev.todolist.model.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тело запроса объекта Action
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ActionDto {

    /**
     * id объекта
     */
    private Integer id;

    /**
     * описание
     */
    private String description;

    /**
     * исполнитель
     */
    private Person person;
}
