package jj.projects.worldsdashboard.data._2021.PlayInPlayer;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import jj.projects.worldsdashboard.model._2021.PlayInPlayer2021;

public class PlayInPlayerProcessor2021 implements ItemProcessor<PlayInPlayerInput2021, PlayInPlayer2021> {

    // private static final Logger log = LoggerFactory.getLogger(PlayInPlayerProcessor2021.class);

    @Override
    public PlayInPlayer2021 process(final PlayInPlayerInput2021 playerInput) throws Exception {
        PlayInPlayer2021 player = new PlayInPlayer2021();
          player.setPlayer(playerInput.getPlayer());
          player.setTeam(playerInput.getTeam());
          player.setPosition(playerInput.getPosition());
          player.setGoldPerMinute(Integer.parseInt(playerInput.getGold_per_minute()));
          player.setWinrate(playerInput.getWinrate());
          player.setCounterPickrate(playerInput.getCounter_pickrate());
          player.setKills(Integer.parseInt(playerInput.getKills()));
          player.setDeaths(Integer.parseInt(playerInput.getDeaths()));
          player.setAssists(Integer.parseInt(playerInput.getAssists()));
          player.setKda(Float.parseFloat(playerInput.getKda()));
          player.setKp(playerInput.getKp());
          player.setKillShare(playerInput.getKill_share());
          player.setShareTeamDeaths(playerInput.getShare_team_deaths());
          player.setFirstBloodRate(playerInput.getFirst_blood_rate());
          player.setGoldDiff10(Integer.parseInt(playerInput.getGold_diff10()));
          player.setXpDiff10(Integer.parseInt(playerInput.getXp_diff10()));
          player.setCsDiff10(Float.parseFloat(playerInput.getCs_diff10()));
          player.setCspm(Float.parseFloat(playerInput.getCspm()));
          player.setShareTeamDeaths15(playerInput.getShare_team_damage15());
          player.setDamagePerMinute(Integer.parseInt(playerInput.getDamage_per_minute()));
          player.setShareDamage(playerInput.getShare_damage());
          player.setShareTeamDamage15(playerInput.getShare_team_damage15());
          player.setAverageGoldPerMinute(Integer.parseInt(playerInput.getAverage_gold_per_minute()));
          player.setGoldShare(playerInput.getGold_share());
          player.setNeutralObjectiveStolen(Integer.parseInt(playerInput.getNeutral_objective_stolen()));
          player.setWardsPerMinute(Float.parseFloat(playerInput.getWards_cleared_per_minute()));
          player.setControlWardsPerMinute(Float.parseFloat(playerInput.getControl_wards_per_minute()));
          player.setWardsClearedPerMinute(Float.parseFloat(playerInput.getWards_cleared_per_minute()));
        return player;
    }

}