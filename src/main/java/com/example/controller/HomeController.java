package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping("")
    public String welcome() {
        return "Welcome to default page";
    }

    @GetMapping("/user")
    public String welcomeUser() {
        return "Welcome to default user's page";
    }

    @GetMapping("/admin")
    public String welcomeAdmin() {
        return "Welcome to default admin's page";
    }


}
