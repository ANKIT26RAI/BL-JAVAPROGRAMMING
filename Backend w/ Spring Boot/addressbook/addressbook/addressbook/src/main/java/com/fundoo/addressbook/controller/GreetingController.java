package com.fundoo.addressbook.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Welcome to Address Book App Backend";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Address Book App is running successfully";
    }
}