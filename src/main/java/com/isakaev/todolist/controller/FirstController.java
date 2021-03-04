package com.isakaev.todolist.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("rest")
public class FirstController {

    // в видео к заданию говорится повторить предыдущий урок, в задании написанно метод Get, поэтому 2 метода с одним мапингом.
    @RequestMapping("/")
    public String test() {
        return (new Date()).toString();
    }

    @GetMapping("/")
    public String testGet() {
        return (new Date()).toString();
    }

    @RequestMapping("/hello")
    public String hello(){
        return "HELLO";
    }
}
