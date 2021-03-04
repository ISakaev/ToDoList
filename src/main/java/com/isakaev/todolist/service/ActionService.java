package com.isakaev.todolist.service;

import com.isakaev.todolist.model.Action;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Сервис для работы с объектами Action
 */
public interface ActionService {

    /**
     * Вернуть действия
     *
     * @return список действий
     */
    public List<Action> getActions();

    /**
     * Вернуть действия по id
     *
     * @param id id действия
     * @return действие
     */
    public Action getAction(Integer id);

    /**
     * Добавить действие
     *
     * @param action действие
     */
    public Integer saveAction(Action action);

    /**
     * Обновить действие
     *
     * @param action действие
     * @param id id действия
     * @return действие
     */
    public Action updateActionById(Action action, Integer id);

    /**
     * Удалить действие
     *
     * @param id id действия
     */
    public void deleteActionById(Integer id);

    /**
     * Удалить опросы
     */
    public void deleteAllActions();
}
