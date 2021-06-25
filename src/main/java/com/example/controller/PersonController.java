package com.example.controller;

import com.example.dto.PersonDto;
import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("")
    public List<PersonDto> getAllUsers() {
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getUserById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public boolean addUser(@Valid @RequestBody PersonDto personDto) {
        return personService.addPerson(personDto);
    }

    @PostMapping(path = "/delete/{id}")
    public boolean deleteUser(@PathVariable int id) {
        return personService.deletePersonById(id);
    }
}
