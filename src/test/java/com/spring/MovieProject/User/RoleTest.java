package com.spring.MovieProject.User;


import com.spring.MovieProject.entity.Role;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.repository.RoleRepository;
import com.spring.MovieProject.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class RoleTest {


    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("add Role")
    public void test() {
        Role ADMIN = new Role();
        ADMIN.setId(1);
        ADMIN.setName("ADMIN");

        Role USER = new Role();
        USER.setId(2);
        USER.setName("USER");

        List<Role> roleList = List.of(ADMIN, USER);
        roleRepository.saveAll(roleList);
    }

}
