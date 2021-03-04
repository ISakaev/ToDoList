package com.isakaev.todolist.controller;


import com.isakaev.todolist.dto.PersonDto;
import com.isakaev.todolist.model.Person;
import com.isakaev.todolist.repository.PersonRepository;
import com.isakaev.todolist.service.ConverterDtoToModel;
import com.isakaev.todolist.service.PersonService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Контроллер запросов Person
 */
@ApiOperation(value = "/persons", tags = "Person Controller")
@RestController
@RequestMapping("/persons")
public class PersonController {

//    private PersonRepository personRepository;

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

//    /**
//     * Получить объекты Person
//     */
    @GetMapping("/")
    @PreAuthorize("hasAuthority('developers:read')")
    @ApiOperation(value = "Получить объекты Person", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объекты Person успешно найдены")
    })
    public ResponseEntity getPersons(){
        List<PersonDto> personDtoList = ConverterDtoToModel.convertPersonToPersonDto(personService.getPersons());
        return ResponseEntity.ok(personDtoList);
    }

//    /**
//     * Получить объект Person по id
//     */
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:read')")
    @ApiOperation(value = "Получить объект Person по id", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объект Person успешно найден"),
            @ApiResponse(code = 500, message = "Объект Person с таким id не существует")
    })
    public ResponseEntity getPerson(@PathVariable Integer id){
        if (id == null){
            List<PersonDto> personDtoList = ConverterDtoToModel.convertPersonToPersonDto(personService.getPersons());
            return ResponseEntity.ok(personDtoList);
        }
        PersonDto personDto = ConverterDtoToModel.convertPersonToPersonDto(personService.getPerson(id));
        return ResponseEntity.ok(personDto);

    }

//    /**
//     * Создать объект Person
//     */
    @PostMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Создать объект Person", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объект Person успешно создан")
    })
    public ResponseEntity savePerson(@RequestBody PersonDto personDto){
        Person person = ConverterDtoToModel.convertPersonDtoToModel(personDto);
        return ResponseEntity.ok(personService.savePerson(person));
    }

//    /**
//     * Изменить объект Person по id
//     */
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Обновление объекта Person", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Объект Person успешно обновлен"),
            @ApiResponse(code = 500, message = "Объект Person с таким id не существует")
    })
    public ResponseEntity updatePersonById(@RequestBody PersonDto personDto, @PathVariable Integer id){
        Person person = ConverterDtoToModel.convertPersonDtoToModel(personDto);
        return ResponseEntity.ok(personService.updatePersonById(person, id));


    }

//    /**
//     * Удалить Person по id
//     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Удаление объекта Person", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Объект Person успешно удален"),
            @ApiResponse(code = 500, message = "Объект Person с таким id не существует")
    })
    public ResponseEntity deletePersonById(@PathVariable Integer id){
        personService.deletePersonById(id);
        return ResponseEntity.noContent().build();
    }

//    /**
//     * Удалить все объекты Person
//     */
    @DeleteMapping("/")
    @PreAuthorize("hasAuthority('developers:write')")
    @ApiOperation(value = "Удаление всех объектов Person", response = ResponseEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Объекты Person успешно удалены")
    })
    public ResponseEntity deleteAllPersons(){
        personService.deleteAllPersons();
        return ResponseEntity.noContent().build();
    }


}
