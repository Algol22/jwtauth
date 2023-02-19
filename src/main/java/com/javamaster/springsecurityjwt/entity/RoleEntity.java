package com.javamaster.springsecurityjwt.entity;

import com.javamaster.springsecurityjwt.repository.RoleEntityRepository;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "jwt_role_table")
@Data
@Component
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private UserEntity userEntity;

    public RoleEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public RoleEntity() {
    }

}

