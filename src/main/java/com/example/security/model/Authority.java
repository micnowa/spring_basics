package com.example.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
@NoArgsConstructor
public class Authority {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name = "roles")
    private String roles;
}
