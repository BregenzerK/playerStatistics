package com.spring.api.playerstatistics.csv;

import com.spring.api.playerstatistics.model.Player;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@EnableBatchProcessing
@Configuration
@AllArgsConstructor
@Slf4j
public class CsvFileToDatabaseConfig {

    public JobBuilderFactory jobBuilderFactory;
    public StepBuilderFactory stepBuilderFactory;
    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<Player> csvAnimeReader() {
        FlatFileItemReader<Player> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("import/players.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Player>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"ranking", "seasonId", "seasonName", "tournamentId", "tournamentRegionId",
                        "tournamentRegionCode", "regionCode", "tournamentName", "tournamentShortName", "firstName",
                        "lastName", "playerId", "isActive", "isOpta", "teamId", "teamName", "playedPositions", "age",
                        "height", "weight", "positionText", "apps", "subOn", "minsPlayed", "rating", "goal",
                        "assistTotal", "yellowCard", "redCard", "shotsPerGame", "aerialWonPerGame", "manOfTheMatch",
                        "name", "isPlayerInTheMatch", "playedPositionsShort", "passSuccess"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Player>() {{
                setTargetType(Player.class);
            }});
        }});
        log.info("confogure reader {}", reader);
        return reader;
    }


    @Bean
    ItemProcessor<Player, Player> csvPlayerProcessor() {
        return new PlayerProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Player> csvPlayerWriter() {
        JdbcBatchItemWriter<Player> csvPlayerWriter = new JdbcBatchItemWriter<>();
        csvPlayerWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        csvPlayerWriter.setSql("INSERT INTO players (ranking, season_id, season_name, tournament_id, tournament_region_id," +
                " tournament_region_code, region_code, tournament_name, tournament_short_name, first_name, last_name, player_id, " +
                "active, opta, team_id, team_name, played_positions, age, height, weight, position_text, apps, sub_on, " +
                "mins_played, rating, goal, assist_total, yellow_card, red_card, shots_per_game, aerial_won_per_game, man_of_the_match, " +
                "name, player_in_the_match, played_positions_short, pass_Success) " +
                "VALUES (:ranking, :seasonId, :seasonName, :tournamentId, :tournamentRegionId, :tournamentRegionCode, " +
                ":regionCode, :tournamentName, :tournamentShortName, :firstName, :lastName, :playerId, :active, :opta, " +
                ":teamId, :teamName, :playedPositions, :age, :height, :weight, :positionText, :apps, :subOn, :minsPlayed, " +
                ":rating, :goal, :assistTotal, :yellowCard, :redCard, :shotsPerGame, :aerialWonPerGame, :manOfTheMatch, " +
                ":name, :playerInTheMatch, :playedPositionsShort, :passSuccess)");
        csvPlayerWriter.setDataSource(dataSource);
        return csvPlayerWriter;
    }

    @Bean
    public Step csvFileToDatabaseStep() {
        return stepBuilderFactory.get("csvFileToDatabaseStep")
                .<Player, Player>chunk(1)
                .reader(csvAnimeReader())
                .processor(csvPlayerProcessor())
                .writer(csvPlayerWriter())
                .build();
    }

    @Bean
    Job csvFileToDatabaseJob() {
        return jobBuilderFactory.get("csvFileToDatabaseJob")
                .incrementer(new RunIdIncrementer())
                .flow(csvFileToDatabaseStep())
                .end()
                .build();
    }
}
