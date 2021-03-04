package com.isakaev.todolist.service;


import com.isakaev.todolist.model.security.User;
/**
 * Сервис для работы с объектами User
 */
public interface UserService {

    /**
     * Добавить объект User
     *
     * @param user объект User
     */
    void save(User user);

    /**
     * Поиск пользователя по имени
     *
     * @param username объекта User
     * @return Объект User
     */
    com.isakaev.todolist.model.security.User findByUsername(String username);
}
