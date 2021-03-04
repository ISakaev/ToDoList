package com.isakaev.todolist.controller;

import com.isakaev.todolist.dto.ActionDto;
import com.isakaev.todolist.model.Action;
import com.isakaev.todolist.service.ActionService;
import com.isakaev.todolist.service.ConverterDtoToModel;
import com.isakaev.todolist.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
Что нужно сделать
1) Напишите, какие сущности будут в вашем ToDoList.
2) Укажите их свойства и URL в API для каждой сущности.
3) Пропишите полностью форматы REST JSON API для приложения ToDoList.
 (Создание дела, удаление дела, обновление дела, получение списка, удаление всего списка).
 Веб интерфейс (HTML + JavaScript) в этом задании делать не надо, в данном случае необходимо прописать только запросы.
* */
/**
 * Контроллер запросов Action
 */
@ApiOperation(value = "/actions", tags = "Action Controller")
@RestController
@RequestMapping("/actions")
public class ActionController {

    private ActionService actionService;

    private PersonService personService;

    @Autowired
    public ActionController(ActionService actionService, PersonService personService) {
        this.actionService = actionService;
        this.personService = personService;
    }

//    /**
//     * Получить объекты Action
//     */
    @GetMapping("/")
//    @PreAuthorize("hasAuthority('developers:read')")
    @ApiOperation(value = "Получить объекты Action", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объекты Action успешно найдены")
    })
    public  ResponseEntity getActions(){
        List<ActionDto> actionDtoList = ConverterDtoToModel.convertModelToActionDto(actionService.getActions());
        return ResponseEntity.ok(actionDtoList);
    }

//    /**
//     * Получить объект Action по id
//     */
    @GetMapping("/{id}")
//    @PreAuthorize("hasAuthority('developers:read')")
    @ApiOperation(value = "Получить объект Action по id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объект Action успешно найден"),
            @ApiResponse(code = 500, message = "Объект Action с таким id не существует")
    })
    public ResponseEntity getAction(@PathVariable Integer id){
        if (id == null){
            List<ActionDto> actionDtoList = ConverterDtoToModel.convertModelToActionDto(actionService.getActions());
            return ResponseEntity.ok(actionDtoList);
        }
        ActionDto actionDto = ConverterDtoToModel.convertModelToActionDto(actionService.getAction(id));
        return ResponseEntity.ok(actionDto);
    }

//    /**
//     * Создать объект Action
//     */
    @PostMapping("/")
//    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Создать объект Action", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объект Action успешно создан")
    })
    public ResponseEntity saveAction(@RequestBody ActionDto actionDto){
        Action action = ConverterDtoToModel.convertActionDtoToModel(actionDto);
        return ResponseEntity.ok(actionService.saveAction(action));
    }

//    /**
//     * Изменить объект Action по id
//     */
    @PutMapping("/{id}")
//    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Обновление объекта Action", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объект Action успешно обновлен"),
            @ApiResponse(code = 500, message = "Объект Action с таким id не существует")
    })
    public ResponseEntity updateCaseById(@RequestBody ActionDto actionDto, @PathVariable Integer id){
        Action action = ConverterDtoToModel.convertActionDtoToModel(actionDto);
        return ResponseEntity.ok(actionService.updateActionById(action, id));
    }

//    /**
//     * Удалить Action по id
//     */
    @DeleteMapping("/{id}")
//    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Удаление объекта Action", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Объект Action успешно удален"),
            @ApiResponse(code = 500, message = "Объект Action с таким id не существует")
    })
    public ResponseEntity deleteActionById(@PathVariable Integer id){
        actionService.deleteActionById(id);
        return ResponseEntity.noContent().build();

    }

//    /**
//     * Удалить все объекты Action
//     */
    @DeleteMapping("/")
//    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Удаление всех объектов Action", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Объекты Action успешно удалены")
    })
    public ResponseEntity deleteAllActions(){
        actionService.deleteAllActions();
        return ResponseEntity.noContent().build();
    }
}
