package com.javamaster.springsecurityjwt.entity;

import com.javamaster.springsecurityjwt.repository.RoleEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoData {
        @Autowired
        RoleEntityRepository roleEntityRepository;

    @Autowired
    RoleEntity roleEntity;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        roleEntityRepository.save(new RoleEntity(1, "ROLE_ADMIN"));
        roleEntityRepository.save(new RoleEntity(2, "ROLE_USER"));
    }
}
