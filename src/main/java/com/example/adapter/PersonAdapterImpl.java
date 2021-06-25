package com.example.adapter;

import com.example.dto.PersonDto;
import com.example.hibernate.PersonHibernateManager;
import com.example.model.Person;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonAdapterImpl implements PersonAdapter {
    @Override
    @Transactional
    public List<PersonDto> getAllPersons() {
        List<Person> people = PersonHibernateManager.getAllUsers();

        return people.stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public Person getPersonById(int id) {
        return PersonHibernateManager.getUserById(id);
    }

    @Override
    public boolean addPerson(PersonDto personDto) {
        return PersonHibernateManager.UPDATE_ERROR == PersonHibernateManager.addUser(new Person(personDto));
    }

    @Override
    public boolean deletePersonById(int id) {
        return PersonHibernateManager.deleteUserById(id);
    }
}
