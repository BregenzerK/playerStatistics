package com.spring.api.playerstatistics.controller;

import com.spring.api.playerstatistics.model.Player;
import com.spring.api.playerstatistics.repository.PlayerRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StatisticsController.class)
public class StatisticsControllerTest {

    @MockBean
    private PlayerRepository playerRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    private List<Player> players;
    private Player player;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        this.player = Player.builder()
                .playerId(123)
                .firstName("Test")
                .age(26)
                .active(true)
                .build();

        this.players = Lists.newArrayList();
    }

    @Test
    public void getPlayers() throws Exception {
        given(this.playerRepository.findAll()).willReturn(this.players);
        this.mockMvc.perform(get("/players")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
@Test
    public void getPlayer() throws Exception {
        given(this.playerRepository.findById(123L)).willReturn(java.util.Optional.ofNullable(this.player));
        this.mockMvc.perform(get("/player/{id}", 123)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
