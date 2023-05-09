package jj.projects.worldsdashboard.data._2021.MainTeam;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import jj.projects.worldsdashboard.model._2021.MainTeam2021;

public class MainTeamProcessor2021 implements ItemProcessor<MainTeamInput2021, MainTeam2021> {

    // private static final Logger log = LoggerFactory.getLogger(MainTeamProcessor2021.class);

    @Override
    public MainTeam2021 process(final MainTeamInput2021 teamInput) throws Exception {
        MainTeam2021 team = new MainTeam2021();
        team.setTeam(teamInput.getTeam());
        team.setGamesPlayed(Integer.parseInt(teamInput.getGames_played()));
        team.setWins(Integer.parseInt(teamInput.getWins()));
        team.setLoses(Integer.parseInt(teamInput.getLoses()));
        team.setAverageGameDuration(Float.parseFloat(teamInput.getAverage_game_duration()));
        team.setKills(Integer.parseInt(teamInput.getKills()));
        team.setDeaths(Integer.parseInt(teamInput.getDeaths()));
        team.setKd(Float.parseFloat(teamInput.getKd()));
        team.setCombinedKillsPerMinute(Float.parseFloat(teamInput.getCombined_kills_per_minute()));
        team.setGoldPercentRating(Float.parseFloat(teamInput.getGold_percent_rating()));
        team.setGoldSpentDifference(teamInput.getGold_spent_difference());
        team.setEarlyGameRating(Float.parseFloat(teamInput.getEarly_game_rating()));
        team.setMidLateRating(Float.parseFloat(teamInput.getMid_late_rating()));
        team.setGoldDiff15(Integer.parseInt(teamInput.getGold_diff15()));
        team.setFirstBloodRate(teamInput.getFirst_blood_rate());
        team.setFirstTowerRate(teamInput.getFirst_tower_rate());
        team.setFirstToThreeTowersRate(teamInput.getFirst_to_three_towers_rate());
        team.setTurrentPlatesDestroyed(Float.parseFloat(teamInput.getTurrent_plates_destroyed()));
        team.setRiftHeraldRate(teamInput.getRift_herald_rate());
        team.setFirstDragonRate(teamInput.getFirst_dragon_rate());
        team.setDragonControlRate(teamInput.getDragon_control_rate());
        team.setElderDragonRate(teamInput.getElder_dragon_rate());
        team.setFirstBaronRate(teamInput.getFirst_baron_rate());
        team.setBaronControlRate(teamInput.getBaron_control_rate());
        team.setLaneControl(teamInput.getLane_control());
        team.setJungleControl(teamInput.getJungle_control());
        team.setWardsPerMinute(Float.parseFloat(teamInput.getWards_per_minute()));
        team.setControlWardsPerMinute(Float.parseFloat(teamInput.getControl_wards_per_minute()));
        team.setWardsClearedPerMinute(Float.parseFloat(teamInput.getWards_cleared_per_minute()));
        return team;
    }

}