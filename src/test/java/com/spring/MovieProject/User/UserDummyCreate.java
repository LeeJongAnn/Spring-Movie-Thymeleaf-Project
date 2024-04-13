package com.spring.MovieProject.User;


import com.spring.MovieProject.entity.Role;
import com.spring.MovieProject.entity.User;
import com.spring.MovieProject.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@DataJpaTest()
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserDummyCreate {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("더미 유저 테스트")
    public void createDummyUser() {
        List<User> userlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            User user = new User();
            user.setUsername("dummy" + i);
            user.setEmail("example" + i + "@gmail.com");
            user.setPassword("test" + i);
            userlist.add(user);
        }
        userRepository.saveAll(userlist);

    }

    @Test
    public void UserAddRole() {


        User user = new User();
        user.setUsername("아무개");
        user.setEmail("HmmNya@gmail.com");
        user.setPassword("1234");
        Role ADMIN = em.find(Role.class, 1);


        userRepository.save(user);
    }

}
