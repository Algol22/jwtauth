package com.javamaster.springsecurityjwt.entity;

import lombok.Data;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role_table")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


}