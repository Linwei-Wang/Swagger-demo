package io.swagger.repository;

import io.swagger.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface teamRepository extends JpaRepository<Team, Integer> {
}
