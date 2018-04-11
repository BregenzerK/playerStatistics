package com.spring.api.playerstatistics.repository;

import com.spring.api.playerstatistics.model.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}
