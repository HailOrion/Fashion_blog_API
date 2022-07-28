package com.fashionblog.demo.entities;


import com.fashionblog.demo.enums.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public abstract class Person {

    private String firstName;
    private String lastName;
    @Email
    @Column(nullable = false, unique = true)
    private String email;
    @Size(min = 6)
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
}
