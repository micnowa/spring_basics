package com.example.service;

import com.example.adapter.UserAdapter;
import com.example.dto.PersonDto;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserAdapter userAdapter;

    @Autowired
    public UserServiceImpl(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @Override
    public List<PersonDto> getAllUsers() {
        return userAdapter.getAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return userAdapter.getUserById(id);
    }

    @Override
    public boolean addUser(PersonDto personDto) {
        return userAdapter.addUser(personDto);
    }

    @Override
    public boolean deleteUserById(int id) {
        return userAdapter.deleteUserById(id);
    }
}
