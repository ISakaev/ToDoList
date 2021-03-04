package com.isakaev.todolist.controller;

import com.isakaev.todolist.model.security.User;
import com.isakaev.todolist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "/registration";
    }

    @PostMapping("/registration")
    public String addNewUser(User user, Model model){
        User newUser = userService.findByUsername(user.getUsername());
        if (newUser != null){
            model.addAttribute("userExist", user );
            return "/registration";
        }
        userService.save(user);
        return "redirect:/login";
    }
}
