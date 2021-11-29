package io.swagger.service;


import io.swagger.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class playerService {
    @Autowired
    private io.swagger.repository.playerRepository playerRepository;
    public List<Player> findAll() {
        return playerRepository.findAll();
    }
}
