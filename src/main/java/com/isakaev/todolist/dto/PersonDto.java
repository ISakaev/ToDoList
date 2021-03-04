package com.isakaev.todolist.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Тело запроса объекта Person
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    /**
     * id объекта
     */
    private Integer id;

    /**
     * имя
     */
    private String name;

    /**
     * телефон
     */
    private String phone;

    /**
     * адрес
     */
    private String address;
}
