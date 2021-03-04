package com.isakaev.todolist.service;

import com.isakaev.todolist.dto.ActionDto;
import com.isakaev.todolist.dto.PersonDto;
import com.isakaev.todolist.model.Action;
import com.isakaev.todolist.model.Person;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ConverterDtoToModel {

    public static Action convertActionDtoToModel(ActionDto actionDto){
//        return Action.builder().id(actionDto.getId())
//                .description(actionDto.getDescription())
//                .person(actionDto.getPerson())
//                .build();
        ModelMapper mapper = new ModelMapper();
        Action actionMapper = mapper.map(actionDto, Action.class);
        return actionMapper;
    }

    public static ActionDto convertModelToActionDto(Action action){
        ModelMapper mapper = new ModelMapper();
        ActionDto actionDtoMapper = mapper.map(action, ActionDto.class);
        return actionDtoMapper;
    }

    public static List<ActionDto> convertModelToActionDto (List<Action> actionList){
        List<ActionDto> actionDtoList = actionList.stream().map(ConverterDtoToModel::convertModelToActionDto).collect(Collectors.toList());
        return actionDtoList;
    }

    public static Person convertPersonDtoToModel(PersonDto personDto){
//        return  Person.builder().id(personDto.getId())
//                .name(personDto.getName())
//                .phone(personDto.getPhone())
//                .address(personDto.getAddress())
//                .build();
        ModelMapper mapper = new ModelMapper();
        Person personMap = mapper.map(personDto, Person.class);
        return personMap;
    }

    public static PersonDto convertPersonToPersonDto(Person person){
        ModelMapper mapper = new ModelMapper();
        PersonDto personDtoMap = mapper.map(person, PersonDto.class);
        return personDtoMap;
    }

    public static List<PersonDto> convertPersonToPersonDto(List<Person> personList){
        List<PersonDto> personDtoList = personList.stream().map(ConverterDtoToModel::convertPersonToPersonDto).collect(Collectors.toList());
        return personDtoList;
    }
}
