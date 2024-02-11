package com.final_year_project.Aluminium_production_management_system.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@Entity
public class User {
    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    //@Column(name = "userid", columnDefinition = "varchar(100)")
    private String id;
    private String first_name;
    private String last_name;
    private String password;
    private String email;
    private int age;


}
