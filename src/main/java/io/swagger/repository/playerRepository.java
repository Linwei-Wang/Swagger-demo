package io.swagger.repository;


import io.swagger.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface playerRepository extends JpaRepository<Player, Integer> {
}
