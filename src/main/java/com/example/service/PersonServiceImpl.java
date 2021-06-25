package com.example.service;

import com.example.adapter.PersonAdapter;
import com.example.dto.PersonDto;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {
    PersonAdapter personAdapter;

    @Autowired
    public PersonServiceImpl(PersonAdapter personAdapter) {
        this.personAdapter = personAdapter;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        return personAdapter.getAllPersons();
    }

    @Override
    public Person getPersonById(int id) {
        return personAdapter.getPersonById(id);
    }

    @Override
    public boolean addPerson(PersonDto personDto) {
        return personAdapter.addPerson(personDto);
    }

    @Override
    public boolean deletePersonById(int id) {
        return personAdapter.deletePersonById(id);
    }
}
