package com.isakaev.todolist.service;

import com.isakaev.todolist.model.Person;

import java.util.List;

/**
 * Сервис для работы с объектами Person
 */
public interface PersonService {

    /**
     * Вернуть действия
     *
     * @return список действий
     */
     List<Person> getPersons();

    /**
     * Вернуть объект Person по id
     *
     * @param id id объекта Person
     * @return объект Person
     */
     Person getPerson(Integer id);

    /**
     * Добавить объект Person
     *
     * @param person объект Person
     */
    Integer savePerson(Person person);

    /**
     * Обновить объект Person
     *
     * @param person объект Person
     * @param id id объекта Person
     * @return действие
     */
    Person updatePersonById(Person person, Integer id);

    /**
     * Удалить объекты Person
     *
     * @param id id объекта Person
     */
    void deletePersonById(Integer id);

    /**
     * Удалить объекты Person
     */
    void deleteAllPersons();

}
