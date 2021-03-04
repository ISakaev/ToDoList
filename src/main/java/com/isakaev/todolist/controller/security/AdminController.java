package com.isakaev.todolist.controller.security;

import com.isakaev.todolist.model.Action;
import com.isakaev.todolist.model.security.User;
import com.isakaev.todolist.service.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер обработки запросов админа
 */
//@RestController
@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin")
    public String userList(Model model) {
        Iterable<User> userIterable = userService.allUsers();
        List<User> userList = new ArrayList<>();
        userIterable.forEach(userList::add);
        model.addAttribute("userList", userList);
        return "admin";
    }

    @GetMapping("/showUsers/{id}")
    public String showUserById (@PathVariable Long id, Model model){

        model.addAttribute("user", userService.findUserById(id));
        return "user/userShowById";
    }

    @GetMapping("/deleteUsers/{id}")
    public String deleteUserById (@PathVariable Long id){

        userService.deleteUser(id);
        return "redirect:/admin";
    }
}
