package com.fundoo.contactsapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Contacts App Backend";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello Ankit, Spring Boot is running successfully";
    }
}