package com.isakaev.todolist.controller;

import com.isakaev.todolist.model.Action;
import com.isakaev.todolist.model.Person;
import com.isakaev.todolist.model.security.Role;
import com.isakaev.todolist.repository.RoleRepository;
import com.isakaev.todolist.service.ActionService;
import com.isakaev.todolist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер шаблонов
 */
//@RestController
@Controller
public class DefaultController {

    private ActionService actionService;

    private PersonService personService;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public DefaultController(PersonService personService, ActionService actionService) {
        this.personService = personService;
        this.actionService = actionService;
    }

//    @GetMapping("/login")
//    public String login () {
//    return "/login";
//    }
    /**
     * Получить шаблон домашней страницы
     */
    @GetMapping("/")
    public String rootPage () {
        if (!roleRepository.existsById(1L)){
            roleRepository.save(new Role(1L, "ROLE_USER"));
            roleRepository.save(new Role(2L, "ROLE_ADMIN"));
        }
        return "index";
    }

    /**
     * Получить шаблон домашней страницы
     */

    @GetMapping("/home")
    public String homePage () {
        return "home";
    }

    /**
     * Получить шаблон списка actions
     */
    @GetMapping("/showActions")
//    @PreAuthorize("hasAuthority('developers:read')")
    public String showAllActions (Model model){
        Iterable<Action> actionIterable = actionService.getActions();
        List<Action> actionList = new ArrayList<>();
        actionIterable.forEach(actionList::add);
        model.addAttribute("actionList",actionList);
        return "action/actionsShow";
    }

    /**
     * Получить шаблон action по id
     */
    @GetMapping("/showActions/{id}")
//    @PreAuthorize("hasAuthority('developers:read')")
    public String showActionById (@PathVariable Integer id, Model model){

        model.addAttribute("action", actionService.getAction(id));
        return "action/actionShowById";
    }

    /**
     * Получить шаблон создания action
     */
    @GetMapping("/newaction")
//    @PreAuthorize("hasAuthority('developers:read')")
    public String newAction(Model model){
        model.addAttribute("action", new Action());
        return "action/actionNew";
    }

    /**
     * Создание action
     */
    @PostMapping("createaction/")
//    @PreAuthorize("hasAuthority('developers:write')")
    public String createNewAction(@ModelAttribute("action") Action action ){
        actionService.saveAction(action);
        return "redirect:/showActions";
    }

    /**
     * Получить шаблон списка persons
     */
    @GetMapping("/showPersons")
//    @PreAuthorize("hasAuthority('developers:read')")
    public String showAllPersons (Model model){
        Iterable<Person> personIterable = personService.getPersons();
        List<Person> personList = new ArrayList<>();
        personIterable.forEach(personList::add);
        model.addAttribute("personList",personList);
        return "person/peopleShow";
    }

    /**
     * Получить шаблон person по id
     */
    @GetMapping("/showPersons/{id}")
//    @PreAuthorize("hasAuthority('developers:read')")
    public String showPersonById (@PathVariable Integer id, Model model){
        model.addAttribute("person", personService.getPerson(id));
        return "person/peopleShowId";
    }

    /**
     * Получить шаблон создания person
     */
    @GetMapping("newperson/")
//    @PreAuthorize("hasAuthority('developers:read')")
    public String newPerson(Model model){
        model.addAttribute("person", new Person());
        return "person/peopleNew";
    }

    /**
     * Создание person
     */
    @PostMapping("createperson/")
//    @PreAuthorize("hasAuthority('developers:write')")
    public String createNewPeople(@ModelAttribute("person") Person person ){
        personService.savePerson(person);
        return "redirect:/showPersons";
    }
}