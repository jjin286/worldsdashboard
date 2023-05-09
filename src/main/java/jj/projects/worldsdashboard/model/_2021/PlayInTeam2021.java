package jj.projects.worldsdashboard.model._2021;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PlayInTeam2021 {
    @Id
    private String team;
    private int gamesPlayed;
    private int wins;
    private int loses;
    private float averageGameDuration;
    private int kills;
    private int deaths;
    private float kd;
    private float combinedKillsPerMinute;
    private float goldPercentRating;
    private String goldSpentDifference;
    private float earlyGameRating;
    private float midLateRating;
    private int goldDiff15;
    private String firstBloodRate;
    private String firstTowerRate;
    private String firstToThreeTowersRate;
    private float turrentPlatesDestroyed;
    private String riftHeraldRate;
    private String firstDragonRate;
    private String dragonControlRate;
    private String elderDragonRate;
    private String firstBaronRate;
    private String baronControlRate;
    private String laneControl;
    private String jungleControl;
    private float wardsPerMinute;
    private float controlWardsPerMinute;
    private float wardsClearedPerMinute;
    
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public int getGamesPlayed() {
        return gamesPlayed;
    }
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public int getLoses() {
        return loses;
    }
    public void setLoses(int loses) {
        this.loses = loses;
    }
    public float getAverageGameDuration() {
        return averageGameDuration;
    }
    public void setAverageGameDuration(float averageGameDuration) {
        this.averageGameDuration = averageGameDuration;
    }
    public int getKills() {
        return kills;
    }
    public void setKills(int kills) {
        this.kills = kills;
    }
    public int getDeaths() {
        return deaths;
    }
    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
    public float getKd() {
        return kd;
    }
    public void setKd(float kd) {
        this.kd = kd;
    }
    public float getCombinedKillsPerMinute() {
        return combinedKillsPerMinute;
    }
    public void setCombinedKillsPerMinute(float combinedKillsPerMinute) {
        this.combinedKillsPerMinute = combinedKillsPerMinute;
    }
    public float getGoldPercentRating() {
        return goldPercentRating;
    }
    public void setGoldPercentRating(float goldPercentRating) {
        this.goldPercentRating = goldPercentRating;
    }
    public String getGoldSpentDifference() {
        return goldSpentDifference;
    }
    public void setGoldSpentDifference(String goldSpentDifference) {
        this.goldSpentDifference = goldSpentDifference;
    }
    public float getEarlyGameRating() {
        return earlyGameRating;
    }
    public void setEarlyGameRating(float earlyGameRating) {
        this.earlyGameRating = earlyGameRating;
    }
    public float getMidLateRating() {
        return midLateRating;
    }
    public void setMidLateRating(float midLateRating) {
        this.midLateRating = midLateRating;
    }
    public int getGoldDiff15() {
        return goldDiff15;
    }
    public void setGoldDiff15(int goldDiff15) {
        this.goldDiff15 = goldDiff15;
    }
    public String getFirstBloodRate() {
        return firstBloodRate;
    }
    public void setFirstBloodRate(String firstBloodRate) {
        this.firstBloodRate = firstBloodRate;
    }
    public String getFirstTowerRate() {
        return firstTowerRate;
    }
    public void setFirstTowerRate(String firstTowerRate) {
        this.firstTowerRate = firstTowerRate;
    }
    public String getFirstToThreeTowersRate() {
        return firstToThreeTowersRate;
    }
    public void setFirstToThreeTowersRate(String firstToThreeTowersRate) {
        this.firstToThreeTowersRate = firstToThreeTowersRate;
    }
    public float getTurrentPlatesDestroyed() {
        return turrentPlatesDestroyed;
    }
    public void setTurrentPlatesDestroyed(float turrentPlatesDestroyed) {
        this.turrentPlatesDestroyed = turrentPlatesDestroyed;
    }
    public String getRiftHeraldRate() {
        return riftHeraldRate;
    }
    public void setRiftHeraldRate(String riftHeraldRate) {
        this.riftHeraldRate = riftHeraldRate;
    }
    public String getFirstDragonRate() {
        return firstDragonRate;
    }
    public void setFirstDragonRate(String firstDragonRate) {
        this.firstDragonRate = firstDragonRate;
    }
    public String getDragonControlRate() {
        return dragonControlRate;
    }
    public void setDragonControlRate(String dragonControlRate) {
        this.dragonControlRate = dragonControlRate;
    }
    public String getElderDragonRate() {
        return elderDragonRate;
    }
    public void setElderDragonRate(String elderDragonRate) {
        this.elderDragonRate = elderDragonRate;
    }
    public String getFirstBaronRate() {
        return firstBaronRate;
    }
    public void setFirstBaronRate(String firstBaronRate) {
        this.firstBaronRate = firstBaronRate;
    }
    public String getBaronControlRate() {
        return baronControlRate;
    }
    public void setBaronControlRate(String baronControlRate) {
        this.baronControlRate = baronControlRate;
    }
    public String getLaneControl() {
        return laneControl;
    }
    public void setLaneControl(String laneControl) {
        this.laneControl = laneControl;
    }
    public String getJungleControl() {
        return jungleControl;
    }
    public void setJungleControl(String jungleControl) {
        this.jungleControl = jungleControl;
    }
    public float getWardsPerMinute() {
        return wardsPerMinute;
    }
    public void setWardsPerMinute(float wardsPerMinute) {
        this.wardsPerMinute = wardsPerMinute;
    }
    public float getControlWardsPerMinute() {
        return controlWardsPerMinute;
    }
    public void setControlWardsPerMinute(float controlWardsPerMinute) {
        this.controlWardsPerMinute = controlWardsPerMinute;
    }
    public float getWardsClearedPerMinute() {
        return wardsClearedPerMinute;
    }
    public void setWardsClearedPerMinute(float wardsClearedPerMinute) {
        this.wardsClearedPerMinute = wardsClearedPerMinute;
    }

    
}
