package com.example.adapter;

import com.example.dto.PersonDto;
import com.example.model.Person;

import java.util.List;


public interface PersonAdapter {
    List<PersonDto> getAllPersons();

    Person getPersonById(int id);

    boolean addPerson(PersonDto user);

    boolean deletePersonById(int id);
}
