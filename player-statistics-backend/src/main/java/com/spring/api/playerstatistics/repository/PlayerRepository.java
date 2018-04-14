package com.spring.api.playerstatistics.repository;

import com.spring.api.playerstatistics.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAllByOrderByRanking();
}
