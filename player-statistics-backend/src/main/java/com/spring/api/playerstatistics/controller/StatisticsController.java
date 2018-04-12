package com.spring.api.playerstatistics.controller;

import com.spring.api.playerstatistics.model.Player;
import com.spring.api.playerstatistics.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@AllArgsConstructor
public class StatisticsController {

    private PlayerRepository playerRepository;

    @GetMapping(path = "/players")
    public Iterable<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @GetMapping(path = "/player/{id}")
    public Optional<Player> getPlayer(@PathVariable("id") long id){
        return playerRepository.findById(id);
    }
}
