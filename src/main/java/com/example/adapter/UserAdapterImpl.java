package com.example.adapter;

import com.example.dto.PersonDto;
import com.example.hibernate.PersonHibernateManager;
import com.example.model.User;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserAdapterImpl implements UserAdapter {
    @Override
    @Transactional
    public List<PersonDto> getAllUsers() {
        List<User> users = PersonHibernateManager.getAllUsers();

        return users.stream()
                .map(PersonDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(int id) {
        return PersonHibernateManager.getUserById(id);
    }

    @Override
    public boolean addUser(PersonDto personDto) {
        return PersonHibernateManager.UPDATE_ERROR == PersonHibernateManager.addUser(new User(personDto));
    }

    @Override
    public boolean deleteUserById(int id) {
        return PersonHibernateManager.deleteUserById(id);
    }
}
