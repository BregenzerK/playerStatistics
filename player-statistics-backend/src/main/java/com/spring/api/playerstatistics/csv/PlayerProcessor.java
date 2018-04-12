package com.spring.api.playerstatistics.csv;

import com.spring.api.playerstatistics.model.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class PlayerProcessor implements ItemProcessor<Player, Player> {

    @Override
    public Player process(Player csvPlayer) {
        log.info("batch script {}", csvPlayer);
        return csvPlayer;
    }
}
