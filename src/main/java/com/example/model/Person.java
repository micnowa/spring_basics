package com.example.model;

import com.example.dto.PersonDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@NoArgsConstructor
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;
    @Column(name = "user_name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "age")
    private int age;

    @OneToMany
    @JoinTable(name = "order")
    private List<Order> orders;

    public Person(PersonDto personDto) {
        this.name = personDto.getName();
        this.surname = personDto.getSurname();
        this.phone = personDto.getPhone();
        this.email = personDto.getEmail();
        this.age = personDto.getAge();
    }
}
