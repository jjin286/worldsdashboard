package jj.projects.worldsdashboard.data;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import jj.projects.worldsdashboard.data._2020.Champion.ChampionInput2020;
import jj.projects.worldsdashboard.data._2020.Champion.ChampionProcessor2020;
import jj.projects.worldsdashboard.data._2020.MainPlayer.MainPlayerInput2020;
import jj.projects.worldsdashboard.data._2020.MainPlayer.MainPlayerProcessor2020;
import jj.projects.worldsdashboard.data._2020.MainTeam.MainTeamInput2020;
import jj.projects.worldsdashboard.data._2020.MainTeam.MainTeamProcessor2020;
import jj.projects.worldsdashboard.data._2020.PlayInPlayer.PlayInPlayerInput2020;
import jj.projects.worldsdashboard.data._2020.PlayInPlayer.PlayInPlayerProcessor2020;
import jj.projects.worldsdashboard.data._2020.PlayInTeam.PlayInTeamInput2020;
import jj.projects.worldsdashboard.data._2020.PlayInTeam.PlayInTeamProcessor2020;
import jj.projects.worldsdashboard.data._2021.Champion.ChampionInput2021;
import jj.projects.worldsdashboard.data._2021.Champion.ChampionProcessor2021;
import jj.projects.worldsdashboard.data._2021.MainPlayer.MainPlayerInput2021;
import jj.projects.worldsdashboard.data._2021.MainPlayer.MainPlayerProcessor2021;
import jj.projects.worldsdashboard.data._2021.MainTeam.MainTeamInput2021;
import jj.projects.worldsdashboard.data._2021.MainTeam.MainTeamProcessor2021;
import jj.projects.worldsdashboard.data._2021.PlayInPlayer.PlayInPlayerInput2021;
import jj.projects.worldsdashboard.data._2021.PlayInPlayer.PlayInPlayerProcessor2021;
import jj.projects.worldsdashboard.data._2021.PlayInTeam.PlayInTeamInput2021;
import jj.projects.worldsdashboard.data._2021.PlayInTeam.PlayInTeamProcessor2021;
import jj.projects.worldsdashboard.data._2022.Champion.ChampionInput2022;
import jj.projects.worldsdashboard.data._2022.Champion.ChampionProcessor2022;
import jj.projects.worldsdashboard.data._2022.MainPlayer.MainPlayerInput2022;
import jj.projects.worldsdashboard.data._2022.MainPlayer.MainPlayerProcessor2022;
import jj.projects.worldsdashboard.data._2022.MainTeam.MainTeamInput2022;
import jj.projects.worldsdashboard.data._2022.MainTeam.MainTeamProcessor2022;
import jj.projects.worldsdashboard.data._2022.PlayInPlayer.PlayInPlayerInput2022;
import jj.projects.worldsdashboard.data._2022.PlayInPlayer.PlayInPlayerProcessor2022;
import jj.projects.worldsdashboard.data._2022.PlayInTeam.PlayInTeamInput2022;
import jj.projects.worldsdashboard.data._2022.PlayInTeam.PlayInTeamProcessor2022;
import jj.projects.worldsdashboard.model._2020.Champion2020;
import jj.projects.worldsdashboard.model._2020.MainPlayer2020;
import jj.projects.worldsdashboard.model._2020.MainTeam2020;
import jj.projects.worldsdashboard.model._2020.PlayInPlayer2020;
import jj.projects.worldsdashboard.model._2020.PlayInTeam2020;
import jj.projects.worldsdashboard.model._2021.Champion2021;
import jj.projects.worldsdashboard.model._2021.MainPlayer2021;
import jj.projects.worldsdashboard.model._2021.MainTeam2021;
import jj.projects.worldsdashboard.model._2021.PlayInPlayer2021;
import jj.projects.worldsdashboard.model._2021.PlayInTeam2021;
import jj.projects.worldsdashboard.model._2022.Champion2022;
import jj.projects.worldsdashboard.model._2022.MainPlayer2022;
import jj.projects.worldsdashboard.model._2022.MainTeam2022;
import jj.projects.worldsdashboard.model._2022.PlayInPlayer2022;
import jj.projects.worldsdashboard.model._2022.PlayInTeam2022;

@Configuration
public class BatchConfiguration {
    
    // ~~~~~~~~~~~~~~~~~~~~ Start of Section for Champions ~~~~~~~~~~~~~~~~~~~~
    //Create reader, processor, write for Champions2020
    @Bean
    public FlatFileItemReader<ChampionInput2020> championReader2020() {
        return new FlatFileItemReaderBuilder<ChampionInput2020>()
                .name("championReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2020/wc_champions.csv"))
                .delimited()
                .names(new String[]{"id","champion","sum_total","win_total","lose_total","pick_rate","winrate_total","sum_blue_side","win_blue_side","lose_blue_side","winrate_blue_side","sum_red_side","win_red_side","lose_red_side","winrate_red_side"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ChampionInput2020>() {{
                    setTargetType(ChampionInput2020.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public ChampionProcessor2020 championProcessor2020() {
        return new ChampionProcessor2020();
    }

    @Bean
    public JdbcBatchItemWriter<Champion2020> championWriter2020(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Champion2020>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO champion2020 ( id,champion,sum_total,win_total,lose_total,pick_rate,winrate_total,sum_blue_side,win_blue_side,lose_blue_side,winrate_blue_side,sum_red_side,win_red_side,lose_red_side,winrate_red_side) VALUES (:id,:champion,:sumTotal,:winTotal,:loseTotal,:pickRate,:winrateTotal,:sumBlueSide,:winBlueSide,:loseBlueSide,:winrateBlueSide,:sumRedSide,:winRedSide,:loseRedSide,:winrateRedSide)")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Champion2020> championWriter2020) {
        return new StepBuilder("step1", jobRepository)
                .<ChampionInput2020, Champion2020> chunk(10, transactionManager)
                .reader(championReader2020())
                .processor(championProcessor2020())
                .writer(championWriter2020)
                .build();
    }

     //Create reader, processor, write for Champions2021
     @Bean
     public FlatFileItemReader<ChampionInput2021> championReader2021() {
         return new FlatFileItemReaderBuilder<ChampionInput2021>()
                 .name("championReader")
                 .resource(new ClassPathResource("Worlds Data/Worlds 2021/wc_champions.csv"))
                 .delimited()
                 .names(new String[]{"id","champion","sum_total","win_total","lose_total","winrate_total","pick_rate","sum_blue_side","win_blue_side","lose_blue_side","winrate_blue_side","sum_red_side","win_red_side","lose_red_side","winrate_red_side","sum_bans","ban_rate","sum_pick_ban","pick_ban_rate"
                 })
                 .fieldSetMapper(new BeanWrapperFieldSetMapper<ChampionInput2021>() {{
                     setTargetType(ChampionInput2021.class);
                 }})
                 .linesToSkip(1)
                 .build();
     }
 
     @Bean
     public ChampionProcessor2021 championProcessor2021() {
         return new ChampionProcessor2021();
     }
 
     @Bean
     public JdbcBatchItemWriter<Champion2021> championWriter2021(DataSource dataSource) {
         return new JdbcBatchItemWriterBuilder<Champion2021>()
                 .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                 .sql("INSERT INTO champion2021 ( id,champion,sum_total,win_total,lose_total,winrate_total,pick_rate,sum_blue_side,win_blue_side,lose_blue_side,winrate_blue_side,sum_red_side,win_red_side,lose_red_side,winrate_red_side,sum_bans,ban_rate,sum_pick_ban,pick_ban_rate) VALUES (:id,:champion,:sumTotal,:winTotal,:loseTotal,:winrateTotal,:pickRate,:sumBlueSide,:winBlueSide,:loseBlueSide,:winrateBlueSide,:sumRedSide,:winRedSide,:loseRedSide,:winrateRedSide,:sumBans,:banRate,:sumPickBan,:pickBanRate)")
                 .dataSource(dataSource)
                 .build();
     }
 
     @Bean
     public Step step2(JobRepository jobRepository,
                       PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Champion2021> championWriter2021) {
         return new StepBuilder("step2", jobRepository)
                 .<ChampionInput2021, Champion2021> chunk(10, transactionManager)
                 .reader(championReader2021())
                 .processor(championProcessor2021())
                 .writer(championWriter2021)
                 .build();
     }

    //Create reader, processor, writer for Champions2022
    @Bean
    public FlatFileItemReader<ChampionInput2022> championReader2022() {
        return new FlatFileItemReaderBuilder<ChampionInput2022>()
                .name("championReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2022/wc_champions.csv"))
                .delimited()
                .names(new String[]{"id","champion","sum_total","win_total","lose_total","winrate_total","pick_rate","sum_blue_side","win_blue_side","lose_blue_side","winrate_blue_side","sum_red_side","win_red_side","lose_red_side","winrate_red_side","sum_bans","ban_rate","sum_pick_ban","pick_ban_rate"
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<ChampionInput2022>() {{
                    setTargetType(ChampionInput2022.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public ChampionProcessor2022 championProcessor2022() {
        return new ChampionProcessor2022();
    }

    @Bean
    public JdbcBatchItemWriter<Champion2022> championWriter2022(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Champion2022>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO champion2022 ( id,champion,sum_total,win_total,lose_total,winrate_total,pick_rate,sum_blue_side,win_blue_side,lose_blue_side,winrate_blue_side,sum_red_side,win_red_side,lose_red_side,winrate_red_side,sum_bans,ban_rate,sum_pick_ban,pick_ban_rate) VALUES (:id,:champion,:sumTotal,:winTotal,:loseTotal,:winrateTotal,:pickRate,:sumBlueSide,:winBlueSide,:loseBlueSide,:winrateBlueSide,:sumRedSide,:winRedSide,:loseRedSide,:winrateRedSide,:sumBans,:banRate,:sumPickBan,:pickBanRate)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step3(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<Champion2022> championWriter2022) {
        return new StepBuilder("step3", jobRepository)
                .<ChampionInput2022, Champion2022> chunk(10, transactionManager)
                .reader(championReader2022())
                .processor(championProcessor2022())
                .writer(championWriter2022)
                .build();
    }
    // ~~~~~~~~~~~~~~~~~~~~ End of Section for Champions ~~~~~~~~~~~~~~~~~~~~

    // ~~~~~~~~~~~~~~~~~~~~ Start of Section for 2020 ~~~~~~~~~~~~~~~~~~~~ 
    //Create reader, processor, write for MainPlayer2020

    @Bean
    public FlatFileItemReader<MainPlayerInput2020> mainPlayerReader2020() {
        return new FlatFileItemReaderBuilder<MainPlayerInput2020>()
                .name("mainPlayerReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2020/wc_players_main.csv"))
                .delimited()
                .names(new String[]{"player","team","position","gold_per_minute","winrate","counter_pickrate","kills","deaths","assists","kda","kp","kill_share","share_team_deaths","first_blood_rate","gold_diff10","xp_diff10","cs_diff10","cspm","share_team_deaths15","damage_per_minute","share_damage","share_team_damage15","average_gold_per_minute","gold_share","neutral_objective_stolen","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MainPlayerInput2020>() {{
                    setTargetType(MainPlayerInput2020.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MainPlayerProcessor2020 mainPlayerProcessor2020() {
        return new MainPlayerProcessor2020();
    }

    @Bean
    public JdbcBatchItemWriter<MainPlayer2020> mainPlayerWriter2020(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<MainPlayer2020>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO main_player2020 (player,team,position,gold_per_minute,winrate,counter_pickrate,kills,deaths,assists,kda,kp,kill_share,share_team_deaths,first_blood_rate,gold_diff10,xp_diff10,cs_diff10,cspm,share_team_deaths15,damage_per_minute,share_damage,share_team_damage15,average_gold_per_minute,gold_share,neutral_objective_stolen,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:player,:team,:position,:goldPerMinute,:winrate,:counterPickrate,:kills,:deaths,:assists,:kda,:kp,:killShare,:shareTeamDeaths,:firstBloodRate,:goldDiff10,:xpDiff10,:csDiff10,:cspm,:shareTeamDeaths15,:damagePerMinute,:shareDamage,:shareTeamDamage15,:averageGoldPerMinute,:goldShare,:neutralObjectiveStolen,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step4(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<MainPlayer2020> mainPlayerWriter2020) {
        return new StepBuilder("step4", jobRepository)
                .<MainPlayerInput2020, MainPlayer2020> chunk(10, transactionManager)
                .reader(mainPlayerReader2020())
                .processor(mainPlayerProcessor2020())
                .writer(mainPlayerWriter2020)
                .build();
    }

    //Create reader, processor, writer for PlayInPlayer2020
    @Bean
    public FlatFileItemReader<PlayInPlayerInput2020> playInPlayerReader2020() {
        return new FlatFileItemReaderBuilder<PlayInPlayerInput2020>()
                .name("mainPlayerReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2020/wc_players_play_in.csv"))
                .delimited()
                .names(new String[]{"player","team","position","gold_per_minute","winrate","counter_pickrate","kills","deaths","assists","kda","kp","kill_share","share_team_deaths","first_blood_rate","gold_diff10","xp_diff10","cs_diff10","cspm","share_team_deaths15","damage_per_minute","share_damage","share_team_damage15","average_gold_per_minute","gold_share","neutral_objective_stolen","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayInPlayerInput2020>() {{
                    setTargetType(PlayInPlayerInput2020.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayInPlayerProcessor2020 playInPlayerProcessor2020() {
        return new PlayInPlayerProcessor2020();
    }

    @Bean
    public JdbcBatchItemWriter<PlayInPlayer2020> playInPlayerWriter2020(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PlayInPlayer2020>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO play_in_player2020 (player,team,position,gold_per_minute,winrate,counter_pickrate,kills,deaths,assists,kda,kp,kill_share,share_team_deaths,first_blood_rate,gold_diff10,xp_diff10,cs_diff10,cspm,share_team_deaths15,damage_per_minute,share_damage,share_team_damage15,average_gold_per_minute,gold_share,neutral_objective_stolen,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:player,:team,:position,:goldPerMinute,:winrate,:counterPickrate,:kills,:deaths,:assists,:kda,:kp,:killShare,:shareTeamDeaths,:firstBloodRate,:goldDiff10,:xpDiff10,:csDiff10,:cspm,:shareTeamDeaths15,:damagePerMinute,:shareDamage,:shareTeamDamage15,:averageGoldPerMinute,:goldShare,:neutralObjectiveStolen,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step5(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<PlayInPlayer2020> playInPlayerWriter2020) {
        return new StepBuilder("step5", jobRepository)
                .<PlayInPlayerInput2020, PlayInPlayer2020> chunk(10, transactionManager)
                .reader(playInPlayerReader2020())
                .processor(playInPlayerProcessor2020())
                .writer(playInPlayerWriter2020)
                .build();
    }

    //Create reader, processor, writer for MainTeam2020
    @Bean
    public FlatFileItemReader<MainTeamInput2020> mainTeamReader2020() {
        return new FlatFileItemReaderBuilder<MainTeamInput2020>()
                .name("mainTeamReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2020/wc_teams_main.csv"))
                .delimited()
                .names(new String[]{"team","games_played","wins","loses","average_game_duration","kills","deaths","kd","combined_kills_per_minute","gold_percent_rating","gold_spent_difference","early_game_rating","mid_late_rating","gold_diff15","first_blood_rate","first_tower_rate","first_to_three_towers_rate","turrent_plates_destroyed","rift_herald_rate","first_dragon_rate","dragon_control_rate","elder_dragon_rate","first_baron_rate","baron_control_rate","lane_control","jungle_control","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MainTeamInput2020>() {{
                    setTargetType(MainTeamInput2020.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MainTeamProcessor2020 mainTeamProcessor2020() {
        return new MainTeamProcessor2020();
    }

    @Bean
    public JdbcBatchItemWriter<MainTeam2020> mainTeamWriter2020(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<MainTeam2020>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO main_team2020 (team,games_played,wins,loses,average_game_duration,kills,deaths,kd,combined_kills_per_minute,gold_percent_rating,gold_spent_difference,early_game_rating,mid_late_rating,gold_diff15,first_blood_rate,first_tower_rate,first_to_three_towers_rate,turrent_plates_destroyed,rift_herald_rate,first_dragon_rate,dragon_control_rate,elder_dragon_rate,first_baron_rate,baron_control_rate,lane_control,jungle_control,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:team,:gamesPlayed,:wins,:loses,:averageGameDuration,:kills,:deaths,:kd,:combinedKillsPerMinute,:goldPercentRating,:goldSpentDifference,:earlyGameRating,:midLateRating,:goldDiff15,:firstBloodRate,:firstTowerRate,:firstToThreeTowersRate,:turrentPlatesDestroyed,:riftHeraldRate,:firstDragonRate,:dragonControlRate,:elderDragonRate,:firstBaronRate,:baronControlRate,:laneControl,:jungleControl,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step6(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<MainTeam2020> mainTeamWriter2020) {
        return new StepBuilder("step6", jobRepository)
                .<MainTeamInput2020, MainTeam2020> chunk(10, transactionManager)
                .reader(mainTeamReader2020())
                .processor(mainTeamProcessor2020())
                .writer(mainTeamWriter2020)
                .build();
    }

    //Create reader, processor, writer for PlayInTeam2020
    @Bean
    public FlatFileItemReader<PlayInTeamInput2020> playInTeamReader2020() {
        return new FlatFileItemReaderBuilder<PlayInTeamInput2020>()
                .name("playInTeamReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2020/wc_teams_play_in.csv"))
                .delimited()
                .names(new String[]{"team","games_played","wins","loses","average_game_duration","kills","deaths","kd","combined_kills_per_minute","gold_percent_rating","gold_spent_difference","early_game_rating","mid_late_rating","gold_diff15","first_blood_rate","first_tower_rate","first_to_three_towers_rate","turrent_plates_destroyed","rift_herald_rate","first_dragon_rate","dragon_control_rate","elder_dragon_rate","first_baron_rate","baron_control_rate","lane_control","jungle_control","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayInTeamInput2020>() {{
                    setTargetType(PlayInTeamInput2020.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayInTeamProcessor2020 playInTeamProcessor2020() {
        return new PlayInTeamProcessor2020();
    }

    @Bean
    public JdbcBatchItemWriter<PlayInTeam2020> playInTeamWriter2020(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PlayInTeam2020>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO play_in_team2020 (team,games_played,wins,loses,average_game_duration,kills,deaths,kd,combined_kills_per_minute,gold_percent_rating,gold_spent_difference,early_game_rating,mid_late_rating,gold_diff15,first_blood_rate,first_tower_rate,first_to_three_towers_rate,turrent_plates_destroyed,rift_herald_rate,first_dragon_rate,dragon_control_rate,elder_dragon_rate,first_baron_rate,baron_control_rate,lane_control,jungle_control,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:team,:gamesPlayed,:wins,:loses,:averageGameDuration,:kills,:deaths,:kd,:combinedKillsPerMinute,:goldPercentRating,:goldSpentDifference,:earlyGameRating,:midLateRating,:goldDiff15,:firstBloodRate,:firstTowerRate,:firstToThreeTowersRate,:turrentPlatesDestroyed,:riftHeraldRate,:firstDragonRate,:dragonControlRate,:elderDragonRate,:firstBaronRate,:baronControlRate,:laneControl,:jungleControl,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step7(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<PlayInTeam2020> playInTeamWriter2020) {
        return new StepBuilder("step7", jobRepository)
                .<PlayInTeamInput2020, PlayInTeam2020> chunk(10, transactionManager)
                .reader(playInTeamReader2020())
                .processor(playInTeamProcessor2020())
                .writer(playInTeamWriter2020)
                .build();
    }
    // ~~~~~~~~~~~~~~~~~~~~ End of Section for 2020 ~~~~~~~~~~~~~~~~~~~~ 



    // ~~~~~~~~~~~~~~~~~~~~ Start of Section for 2021 ~~~~~~~~~~~~~~~~~~~~ 

    //Create reader, processor, write for MainPlayer2021

    @Bean
    public FlatFileItemReader<MainPlayerInput2021> mainPlayerReader2021() {
        return new FlatFileItemReaderBuilder<MainPlayerInput2021>()
                .name("mainPlayerReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2021/wc_players_main.csv"))
                .delimited()
                .names(new String[]{"player","team","position","gold_per_minute","winrate","counter_pickrate","kills","deaths","assists","kda","kp","kill_share","share_team_deaths","first_blood_rate","gold_diff10","xp_diff10","cs_diff10","cspm","share_team_deaths15","damage_per_minute","share_damage","share_team_damage15","average_gold_per_minute","gold_share","neutral_objective_stolen","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MainPlayerInput2021>() {{
                    setTargetType(MainPlayerInput2021.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MainPlayerProcessor2021 mainPlayerProcessor2021() {
        return new MainPlayerProcessor2021();
    }

    @Bean
    public JdbcBatchItemWriter<MainPlayer2021> mainPlayerWriter2021(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<MainPlayer2021>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO main_player2021 (player,team,position,gold_per_minute,winrate,counter_pickrate,kills,deaths,assists,kda,kp,kill_share,share_team_deaths,first_blood_rate,gold_diff10,xp_diff10,cs_diff10,cspm,share_team_deaths15,damage_per_minute,share_damage,share_team_damage15,average_gold_per_minute,gold_share,neutral_objective_stolen,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:player,:team,:position,:goldPerMinute,:winrate,:counterPickrate,:kills,:deaths,:assists,:kda,:kp,:killShare,:shareTeamDeaths,:firstBloodRate,:goldDiff10,:xpDiff10,:csDiff10,:cspm,:shareTeamDeaths15,:damagePerMinute,:shareDamage,:shareTeamDamage15,:averageGoldPerMinute,:goldShare,:neutralObjectiveStolen,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step8(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<MainPlayer2021> mainPlayerWriter2021) {
        return new StepBuilder("step8", jobRepository)
                .<MainPlayerInput2021, MainPlayer2021> chunk(10, transactionManager)
                .reader(mainPlayerReader2021())
                .processor(mainPlayerProcessor2021())
                .writer(mainPlayerWriter2021)
                .build();
    }

    //Create reader, processor, writer for PlayInPlayer2021
    @Bean
    public FlatFileItemReader<PlayInPlayerInput2021> playInPlayerReader2021() {
        return new FlatFileItemReaderBuilder<PlayInPlayerInput2021>()
                .name("playInPlayerReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2021/wc_players_play_in.csv"))
                .delimited()
                .names(new String[]{"player","team","position","gold_per_minute","winrate","counter_pickrate","kills","deaths","assists","kda","kp","kill_share","share_team_deaths","first_blood_rate","gold_diff10","xp_diff10","cs_diff10","cspm","share_team_deaths15","damage_per_minute","share_damage","share_team_damage15","average_gold_per_minute","gold_share","neutral_objective_stolen","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayInPlayerInput2021>() {{
                    setTargetType(PlayInPlayerInput2021.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayInPlayerProcessor2021 playInPlayerProcessor2021() {
        return new PlayInPlayerProcessor2021();
    }

    @Bean
    public JdbcBatchItemWriter<PlayInPlayer2021> playInPlayerWriter2021(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PlayInPlayer2021>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO play_in_player2021 (player,team,position,gold_per_minute,winrate,counter_pickrate,kills,deaths,assists,kda,kp,kill_share,share_team_deaths,first_blood_rate,gold_diff10,xp_diff10,cs_diff10,cspm,share_team_deaths15,damage_per_minute,share_damage,share_team_damage15,average_gold_per_minute,gold_share,neutral_objective_stolen,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:player,:team,:position,:goldPerMinute,:winrate,:counterPickrate,:kills,:deaths,:assists,:kda,:kp,:killShare,:shareTeamDeaths,:firstBloodRate,:goldDiff10,:xpDiff10,:csDiff10,:cspm,:shareTeamDeaths15,:damagePerMinute,:shareDamage,:shareTeamDamage15,:averageGoldPerMinute,:goldShare,:neutralObjectiveStolen,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step9(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<PlayInPlayer2021> playInPlayerWriter2021) {
        return new StepBuilder("step9", jobRepository)
                .<PlayInPlayerInput2021, PlayInPlayer2021> chunk(10, transactionManager)
                .reader(playInPlayerReader2021())
                .processor(playInPlayerProcessor2021())
                .writer(playInPlayerWriter2021)
                .build();
    }

    //Create reader, processor, writer for MainTeam2021
    @Bean
    public FlatFileItemReader<MainTeamInput2021> mainTeamReader2021() {
        return new FlatFileItemReaderBuilder<MainTeamInput2021>()
                .name("mainTeamReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2021/wc_teams_main.csv"))
                .delimited()
                .names(new String[]{"team","games_played","wins","loses","average_game_duration","kills","deaths","kd","combined_kills_per_minute","gold_percent_rating","gold_spent_difference","early_game_rating","mid_late_rating","gold_diff15","first_blood_rate","first_tower_rate","first_to_three_towers_rate","turrent_plates_destroyed","rift_herald_rate","first_dragon_rate","dragon_control_rate","elder_dragon_rate","first_baron_rate","baron_control_rate","lane_control","jungle_control","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MainTeamInput2021>() {{
                    setTargetType(MainTeamInput2021.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MainTeamProcessor2021 mainTeamProcessor2021() {
        return new MainTeamProcessor2021();
    }

    @Bean
    public JdbcBatchItemWriter<MainTeam2021> mainTeamWriter2021(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<MainTeam2021>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO main_team2021 (team,games_played,wins,loses,average_game_duration,kills,deaths,kd,combined_kills_per_minute,gold_percent_rating,gold_spent_difference,early_game_rating,mid_late_rating,gold_diff15,first_blood_rate,first_tower_rate,first_to_three_towers_rate,turrent_plates_destroyed,rift_herald_rate,first_dragon_rate,dragon_control_rate,elder_dragon_rate,first_baron_rate,baron_control_rate,lane_control,jungle_control,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:team,:gamesPlayed,:wins,:loses,:averageGameDuration,:kills,:deaths,:kd,:combinedKillsPerMinute,:goldPercentRating,:goldSpentDifference,:earlyGameRating,:midLateRating,:goldDiff15,:firstBloodRate,:firstTowerRate,:firstToThreeTowersRate,:turrentPlatesDestroyed,:riftHeraldRate,:firstDragonRate,:dragonControlRate,:elderDragonRate,:firstBaronRate,:baronControlRate,:laneControl,:jungleControl,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step10(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<MainTeam2021> mainTeamWriter2021) {
        return new StepBuilder("step10", jobRepository)
                .<MainTeamInput2021, MainTeam2021> chunk(10, transactionManager)
                .reader(mainTeamReader2021())
                .processor(mainTeamProcessor2021())
                .writer(mainTeamWriter2021)
                .build();
    }

    //Create reader, processor, writer for PlayInTeam2021
    @Bean
    public FlatFileItemReader<PlayInTeamInput2021> playInTeamReader2021() {
        return new FlatFileItemReaderBuilder<PlayInTeamInput2021>()
                .name("playInTeamReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2021/wc_teams_play_in.csv"))
                .delimited()
                .names(new String[]{"team","games_played","wins","loses","average_game_duration","kills","deaths","kd","combined_kills_per_minute","gold_percent_rating","gold_spent_difference","early_game_rating","mid_late_rating","gold_diff15","first_blood_rate","first_tower_rate","first_to_three_towers_rate","turrent_plates_destroyed","rift_herald_rate","first_dragon_rate","dragon_control_rate","elder_dragon_rate","first_baron_rate","baron_control_rate","lane_control","jungle_control","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayInTeamInput2021>() {{
                    setTargetType(PlayInTeamInput2021.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayInTeamProcessor2021 playInTeamProcessor2021() {
        return new PlayInTeamProcessor2021();
    }

    @Bean
    public JdbcBatchItemWriter<PlayInTeam2021> playInTeamWriter2021(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PlayInTeam2021>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO play_in_team2021 (team,games_played,wins,loses,average_game_duration,kills,deaths,kd,combined_kills_per_minute,gold_percent_rating,gold_spent_difference,early_game_rating,mid_late_rating,gold_diff15,first_blood_rate,first_tower_rate,first_to_three_towers_rate,turrent_plates_destroyed,rift_herald_rate,first_dragon_rate,dragon_control_rate,elder_dragon_rate,first_baron_rate,baron_control_rate,lane_control,jungle_control,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:team,:gamesPlayed,:wins,:loses,:averageGameDuration,:kills,:deaths,:kd,:combinedKillsPerMinute,:goldPercentRating,:goldSpentDifference,:earlyGameRating,:midLateRating,:goldDiff15,:firstBloodRate,:firstTowerRate,:firstToThreeTowersRate,:turrentPlatesDestroyed,:riftHeraldRate,:firstDragonRate,:dragonControlRate,:elderDragonRate,:firstBaronRate,:baronControlRate,:laneControl,:jungleControl,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step11(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<PlayInTeam2021> playInTeamWriter2021) {
        return new StepBuilder("step11", jobRepository)
                .<PlayInTeamInput2021, PlayInTeam2021> chunk(10, transactionManager)
                .reader(playInTeamReader2021())
                .processor(playInTeamProcessor2021())
                .writer(playInTeamWriter2021)
                .build();
    }

    // ~~~~~~~~~~~~~~~~~~~~ End of Section for 2021 ~~~~~~~~~~~~~~~~~~~~ 

    // ~~~~~~~~~~~~~~~~~~~~ Start of Section for 2022 ~~~~~~~~~~~~~~~~~~~~ 

    //Create reader, processor, write for MainPlayer2022

    @Bean
    public FlatFileItemReader<MainPlayerInput2022> mainPlayerReader2022() {
        return new FlatFileItemReaderBuilder<MainPlayerInput2022>()
                .name("mainPlayerReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2022/wc_players_main.csv"))
                .delimited()
                .names(new String[]{"player","team","position","gold_per_minute","winrate","counter_pickrate","kills","deaths","assists","kda","kp","kill_share","share_team_deaths","first_blood_rate","gold_diff10","xp_diff10","cs_diff10","cspm","share_team_deaths15","damage_per_minute","share_damage","share_team_damage15","average_gold_per_minute","gold_share","neutral_objective_stolen","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MainPlayerInput2022>() {{
                    setTargetType(MainPlayerInput2022.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MainPlayerProcessor2022 mainPlayerProcessor2022() {
        return new MainPlayerProcessor2022();
    }

    @Bean
    public JdbcBatchItemWriter<MainPlayer2022> mainPlayerWriter2022(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<MainPlayer2022>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO main_player2022 (player,team,position,gold_per_minute,winrate,counter_pickrate,kills,deaths,assists,kda,kp,kill_share,share_team_deaths,first_blood_rate,gold_diff10,xp_diff10,cs_diff10,cspm,share_team_deaths15,damage_per_minute,share_damage,share_team_damage15,average_gold_per_minute,gold_share,neutral_objective_stolen,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:player,:team,:position,:goldPerMinute,:winrate,:counterPickrate,:kills,:deaths,:assists,:kda,:kp,:killShare,:shareTeamDeaths,:firstBloodRate,:goldDiff10,:xpDiff10,:csDiff10,:cspm,:shareTeamDeaths15,:damagePerMinute,:shareDamage,:shareTeamDamage15,:averageGoldPerMinute,:goldShare,:neutralObjectiveStolen,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step12(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<MainPlayer2022> mainPlayerWriter2022) {
        return new StepBuilder("step12", jobRepository)
                .<MainPlayerInput2022, MainPlayer2022> chunk(10, transactionManager)
                .reader(mainPlayerReader2022())
                .processor(mainPlayerProcessor2022())
                .writer(mainPlayerWriter2022)
                .build();
    }

    //Create reader, processor, writer for PlayInPlayer2022
    @Bean
    public FlatFileItemReader<PlayInPlayerInput2022> playInPlayerReader2022() {
        return new FlatFileItemReaderBuilder<PlayInPlayerInput2022>()
                .name("playInPlayerReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2022/wc_players_play_in.csv"))
                .delimited()
                .names(new String[]{"player","team","position","gold_per_minute","winrate","counter_pickrate","kills","deaths","assists","kda","kp","kill_share","share_team_deaths","first_blood_rate","gold_diff10","xp_diff10","cs_diff10","cspm","share_team_deaths15","damage_per_minute","share_damage","share_team_damage15","average_gold_per_minute","gold_share","neutral_objective_stolen","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayInPlayerInput2022>() {{
                    setTargetType(PlayInPlayerInput2022.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayInPlayerProcessor2022 playInPlayerProcessor2022() {
        return new PlayInPlayerProcessor2022();
    }

    @Bean
    public JdbcBatchItemWriter<PlayInPlayer2022> playInPlayerWriter2022(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PlayInPlayer2022>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO play_in_player2022 (player,team,position,gold_per_minute,winrate,counter_pickrate,kills,deaths,assists,kda,kp,kill_share,share_team_deaths,first_blood_rate,gold_diff10,xp_diff10,cs_diff10,cspm,share_team_deaths15,damage_per_minute,share_damage,share_team_damage15,average_gold_per_minute,gold_share,neutral_objective_stolen,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:player,:team,:position,:goldPerMinute,:winrate,:counterPickrate,:kills,:deaths,:assists,:kda,:kp,:killShare,:shareTeamDeaths,:firstBloodRate,:goldDiff10,:xpDiff10,:csDiff10,:cspm,:shareTeamDeaths15,:damagePerMinute,:shareDamage,:shareTeamDamage15,:averageGoldPerMinute,:goldShare,:neutralObjectiveStolen,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step13(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<PlayInPlayer2022> playInPlayerWriter2022) {
        return new StepBuilder("step13", jobRepository)
                .<PlayInPlayerInput2022, PlayInPlayer2022> chunk(10, transactionManager)
                .reader(playInPlayerReader2022())
                .processor(playInPlayerProcessor2022())
                .writer(playInPlayerWriter2022)
                .build();
    }

    //Create reader, processor, writer for MainTeam2022
    @Bean
    public FlatFileItemReader<MainTeamInput2022> mainTeamReader2022() {
        return new FlatFileItemReaderBuilder<MainTeamInput2022>()
                .name("mainTeamReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2022/wc_teams_main.csv"))
                .delimited()
                .names(new String[]{"team","games_played","wins","loses","average_game_duration","kills","deaths","kd","combined_kills_per_minute","gold_percent_rating","gold_spent_difference","early_game_rating","mid_late_rating","gold_diff15","first_blood_rate","first_tower_rate","first_to_three_towers_rate","turrent_plates_destroyed","rift_herald_rate","first_dragon_rate","dragon_control_rate","elder_dragon_rate","first_baron_rate","baron_control_rate","lane_control","jungle_control","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<MainTeamInput2022>() {{
                    setTargetType(MainTeamInput2022.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public MainTeamProcessor2022 mainTeamProcessor2022() {
        return new MainTeamProcessor2022();
    }

    @Bean
    public JdbcBatchItemWriter<MainTeam2022> mainTeamWriter2022(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<MainTeam2022>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO main_team2022 (team,games_played,wins,loses,average_game_duration,kills,deaths,kd,combined_kills_per_minute,gold_percent_rating,gold_spent_difference,early_game_rating,mid_late_rating,gold_diff15,first_blood_rate,first_tower_rate,first_to_three_towers_rate,turrent_plates_destroyed,rift_herald_rate,first_dragon_rate,dragon_control_rate,elder_dragon_rate,first_baron_rate,baron_control_rate,lane_control,jungle_control,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:team,:gamesPlayed,:wins,:loses,:averageGameDuration,:kills,:deaths,:kd,:combinedKillsPerMinute,:goldPercentRating,:goldSpentDifference,:earlyGameRating,:midLateRating,:goldDiff15,:firstBloodRate,:firstTowerRate,:firstToThreeTowersRate,:turrentPlatesDestroyed,:riftHeraldRate,:firstDragonRate,:dragonControlRate,:elderDragonRate,:firstBaronRate,:baronControlRate,:laneControl,:jungleControl,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step14(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<MainTeam2022> mainTeamWriter2022) {
        return new StepBuilder("step14", jobRepository)
                .<MainTeamInput2022, MainTeam2022> chunk(10, transactionManager)
                .reader(mainTeamReader2022())
                .processor(mainTeamProcessor2022())
                .writer(mainTeamWriter2022)
                .build();
    }

    //Create reader, processor, writer for PlayInTeam2022
    @Bean
    public FlatFileItemReader<PlayInTeamInput2022> playInTeamReader2022() {
        return new FlatFileItemReaderBuilder<PlayInTeamInput2022>()
                .name("playInTeamReader")
                .resource(new ClassPathResource("Worlds Data/Worlds 2022/wc_teams_play_in.csv"))
                .delimited()
                .names(new String[]{"team","games_played","wins","loses","average_game_duration","kills","deaths","kd","combined_kills_per_minute","gold_percent_rating","gold_spent_difference","early_game_rating","mid_late_rating","gold_diff15","first_blood_rate","first_tower_rate","first_to_three_towers_rate","turrent_plates_destroyed","rift_herald_rate","first_dragon_rate","dragon_control_rate","elder_dragon_rate","first_baron_rate","baron_control_rate","lane_control","jungle_control","wards_per_minute","control_wards_per_minute","wards_cleared_per_minute"    
                })
                .fieldSetMapper(new BeanWrapperFieldSetMapper<PlayInTeamInput2022>() {{
                    setTargetType(PlayInTeamInput2022.class);
                }})
                .linesToSkip(1)
                .build();
    }

    @Bean
    public PlayInTeamProcessor2022 playInTeamProcessor2022() {
        return new PlayInTeamProcessor2022();
    }

    @Bean
    public JdbcBatchItemWriter<PlayInTeam2022> playInTeamWriter2022(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<PlayInTeam2022>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("INSERT INTO play_in_team2022 (team,games_played,wins,loses,average_game_duration,kills,deaths,kd,combined_kills_per_minute,gold_percent_rating,gold_spent_difference,early_game_rating,mid_late_rating,gold_diff15,first_blood_rate,first_tower_rate,first_to_three_towers_rate,turrent_plates_destroyed,rift_herald_rate,first_dragon_rate,dragon_control_rate,elder_dragon_rate,first_baron_rate,baron_control_rate,lane_control,jungle_control,wards_per_minute,control_wards_per_minute,wards_cleared_per_minute) VALUES (:team,:gamesPlayed,:wins,:loses,:averageGameDuration,:kills,:deaths,:kd,:combinedKillsPerMinute,:goldPercentRating,:goldSpentDifference,:earlyGameRating,:midLateRating,:goldDiff15,:firstBloodRate,:firstTowerRate,:firstToThreeTowersRate,:turrentPlatesDestroyed,:riftHeraldRate,:firstDragonRate,:dragonControlRate,:elderDragonRate,:firstBaronRate,:baronControlRate,:laneControl,:jungleControl,:wardsPerMinute,:controlWardsPerMinute,:wardsClearedPerMinute)")
                .dataSource(dataSource)
                .build();
    }


    @Bean
    public Step step15(JobRepository jobRepository,
                      PlatformTransactionManager transactionManager, JdbcBatchItemWriter<PlayInTeam2022> playInTeamWriter2022) {
        return new StepBuilder("step15", jobRepository)
                .<PlayInTeamInput2022, PlayInTeam2022> chunk(10, transactionManager)
                .reader(playInTeamReader2022())
                .processor(playInTeamProcessor2022())
                .writer(playInTeamWriter2022)
                .build();
    }

    // ~~~~~~~~~~~~~~~~~~~~ End of Section for 2022 ~~~~~~~~~~~~~~~~~~~~

    //Execute all steps
    @Bean
    public Job importUserJob(JobRepository jobRepository,
                             JobCompletionNotificationListener listener, Step step1, Step step2, Step step3, Step step4, Step step5, Step step6, Step step7, Step step8, Step step9, Step step10, Step step11, Step step12, Step step13, Step step14, Step step15) {
        return new JobBuilder("importUserJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step1)
                .next(step2)
                .next(step3)
                .next(step4)
                .next(step5)
                .next(step6)
                .next(step7)
                .next(step8)
                .next(step9)
                .next(step10)
                .next(step11)
                .next(step12)
                .next(step13)
                .next(step14)
                .next(step15)
                .build();
    }

}
