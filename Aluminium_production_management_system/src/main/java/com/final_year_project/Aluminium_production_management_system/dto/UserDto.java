package com.final_year_project.Aluminium_production_management_system.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private String id;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private int age;
}
