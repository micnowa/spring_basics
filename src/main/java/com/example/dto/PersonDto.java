package com.example.dto;

import com.example.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class PersonDto {
    @NotEmpty(message = "name must not be empty")
    private String name;
    @NotEmpty(message = "surname must not be empty")
    private String surname;
    private String phone;
    @Email(message = "email should be a valid email")
    private String email;
    private int age;

    public PersonDto(User user) {
        this.name = user.getName();
        this.surname = user.getSurname();
        this.phone = user.getPhone();
        this.email = user.getEmail();
        this.age = user.getAge();
    }
}
