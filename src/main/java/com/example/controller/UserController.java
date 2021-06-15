package com.example.controller;

import com.example.dto.PersonDto;
import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<PersonDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public boolean addUser(@Valid @RequestBody PersonDto personDto) {
        return userService.addUser(personDto);
    }

    @PostMapping(path = "/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }
}
