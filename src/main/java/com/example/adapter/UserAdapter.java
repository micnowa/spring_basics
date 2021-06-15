package com.example.adapter;

import com.example.dto.PersonDto;
import com.example.model.User;

import java.util.List;


public interface UserAdapter {
    List<PersonDto> getAllUsers();

    User getUserById(int id);

    boolean addUser(PersonDto user);

    boolean deleteUserById(int id);
}
