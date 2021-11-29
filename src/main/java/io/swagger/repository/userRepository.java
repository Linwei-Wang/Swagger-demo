package io.swagger.repository;

import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public interface userRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String user_name);
}
