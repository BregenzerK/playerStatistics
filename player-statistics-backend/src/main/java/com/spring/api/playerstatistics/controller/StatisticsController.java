package com.spring.api.playerstatistics.controller;

import com.spring.api.playerstatistics.model.Player;
import com.spring.api.playerstatistics.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class StatisticsController {

    private PlayerRepository playerRepository;

    @GetMapping(path = "/players")
    public ResponseEntity getAllPlayers(){
        return new ResponseEntity(playerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/player/{id}")
    public ResponseEntity getPlayer(@PathVariable("id") long id){
        final Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return new ResponseEntity(player, HttpStatus.OK);
        }
            return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
