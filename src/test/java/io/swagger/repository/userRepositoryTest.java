package io.swagger.repository;

import io.swagger.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userRepositoryTest {
    @Autowired
    private userRepository userRepository;
    @Test
    void findAlltest(){
        List<User> users = new ArrayList<User>();
        users = userRepository.findAll();
        System.out.println(users);
        assertTrue(users.size() >= 0);

    }
    @Test
    void findUserByNameTest(){
        User user = new User();
        long id = 1;
        user.setId(id);
        user.setRoles("ROLE_ADMIN");
        user.setUserName("wanglinw");
        user.setPassword("pass");
        user.setActive(true);
        Optional<User> test = userRepository.findByUserName("wanglinw");
        System.out.println(test);
        assertTrue(test.get().equals(user));
    }

}