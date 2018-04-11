package com.spring.api.playerstatistics.service;

import com.spring.api.playerstatistics.model.Player;
import com.spring.api.playerstatistics.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class PlayerService {

    private PlayerRepository playerRepository;

    public Iterable<Player> getAllPlayer() {
        return this.playerRepository.findAll();
    }

    public Optional<Player> getPlayer(long id) {
        return this.playerRepository.findById(id);
    }
}
