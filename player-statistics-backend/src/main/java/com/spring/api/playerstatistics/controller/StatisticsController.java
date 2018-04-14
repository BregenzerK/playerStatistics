package com.spring.api.playerstatistics.controller;

import com.spring.api.playerstatistics.model.Player;
import com.spring.api.playerstatistics.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class StatisticsController {

    private PlayerRepository playerRepository;

    @CrossOrigin
    @GetMapping(path = "/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        return new ResponseEntity(playerRepository.findAllByOrderByRanking(), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(path = "/player/{id}")
    public ResponseEntity<Player> getPlayer(@PathVariable("id") long id) {
        final Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return new ResponseEntity(player, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
