package com.example.service;

import com.example.dto.PersonDto;
import com.example.model.User;

import java.util.List;

public interface UserService {
    List<PersonDto> getAllUsers();
    User getUserById(int id);
    boolean addUser(PersonDto personDto);
    boolean deleteUserById(int id);
}
