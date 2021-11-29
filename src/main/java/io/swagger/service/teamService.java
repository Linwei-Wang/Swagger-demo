package io.swagger.service;


import io.swagger.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class teamService {

    @Autowired
    private io.swagger.repository.teamRepository teamRepository;
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
