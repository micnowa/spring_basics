package com.example.service;

import com.example.dto.PersonDto;
import com.example.model.Person;

import java.util.List;

public interface PersonService {
    List<PersonDto> getAllPersons();
    Person getPersonById(int id);
    boolean addPerson(PersonDto personDto);
    boolean deletePersonById(int id);
}
