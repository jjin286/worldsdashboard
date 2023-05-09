package jj.projects.worldsdashboard.model._2022;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PlayInPlayer2022 {
    @Id
    private String player;
    private String team;
    private String position;
    private int goldPerMinute;
    private String winrate;
    private String counterPickrate;
    private int kills;
    private int deaths;
    private int assists;
    private float kda;
    private String kp;
    private String killShare;
    private String shareTeamDeaths;
    private String firstBloodRate;
    private int goldDiff10;
    private int xpDiff10;
    private float csDiff10;
    private float cspm;
    private String shareTeamDeaths15;
    private int damagePerMinute;
    private String shareDamage;
    private String shareTeamDamage15;
    private int averageGoldPerMinute;
    private String goldShare;
    private int neutralObjectiveStolen;
    private float wardsPerMinute;
    private float controlWardsPerMinute;
    private float wardsClearedPerMinute;
    
    public String getPlayer() {
        return player;
    }
    public void setPlayer(String player) {
        this.player = player;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public int getGoldPerMinute() {
        return goldPerMinute;
    }
    public void setGoldPerMinute(int goldPerMinute) {
        this.goldPerMinute = goldPerMinute;
    }
    public String getWinrate() {
        return winrate;
    }
    public void setWinrate(String winrate) {
        this.winrate = winrate;
    }
    public String getCounterPickrate() {
        return counterPickrate;
    }
    public void setCounterPickrate(String counterPickrate) {
        this.counterPickrate = counterPickrate;
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
    public int getAssists() {
        return assists;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public float getKda() {
        return kda;
    }
    public void setKda(float kda) {
        this.kda = kda;
    }
    public String getKp() {
        return kp;
    }
    public void setKp(String kp) {
        this.kp = kp;
    }
    public String getKillShare() {
        return killShare;
    }
    public void setKillShare(String killShare) {
        this.killShare = killShare;
    }
    public String getShareTeamDeaths() {
        return shareTeamDeaths;
    }
    public void setShareTeamDeaths(String shareTeamDeaths) {
        this.shareTeamDeaths = shareTeamDeaths;
    }
    public String getFirstBloodRate() {
        return firstBloodRate;
    }
    public void setFirstBloodRate(String firstBloodRate) {
        this.firstBloodRate = firstBloodRate;
    }
    public int getGoldDiff10() {
        return goldDiff10;
    }
    public void setGoldDiff10(int goldDiff10) {
        this.goldDiff10 = goldDiff10;
    }
    public int getXpDiff10() {
        return xpDiff10;
    }
    public void setXpDiff10(int xpDiff10) {
        this.xpDiff10 = xpDiff10;
    }
    public float getCsDiff10() {
        return csDiff10;
    }
    public void setCsDiff10(float csDiff10) {
        this.csDiff10 = csDiff10;
    }
    public float getCspm() {
        return cspm;
    }
    public void setCspm(float cspm) {
        this.cspm = cspm;
    }
    public String getShareTeamDeaths15() {
        return shareTeamDeaths15;
    }
    public void setShareTeamDeaths15(String shareTeamDeaths15) {
        this.shareTeamDeaths15 = shareTeamDeaths15;
    }
    public int getDamagePerMinute() {
        return damagePerMinute;
    }
    public void setDamagePerMinute(int damagePerMinute) {
        this.damagePerMinute = damagePerMinute;
    }
    public String getShareDamage() {
        return shareDamage;
    }
    public void setShareDamage(String shareDamage) {
        this.shareDamage = shareDamage;
    }
    public String getShareTeamDamage15() {
        return shareTeamDamage15;
    }
    public void setShareTeamDamage15(String shareTeamDamage15) {
        this.shareTeamDamage15 = shareTeamDamage15;
    }
    public int getAverageGoldPerMinute() {
        return averageGoldPerMinute;
    }
    public void setAverageGoldPerMinute(int averageGoldPerMinute) {
        this.averageGoldPerMinute = averageGoldPerMinute;
    }
    public String getGoldShare() {
        return goldShare;
    }
    public void setGoldShare(String goldShare) {
        this.goldShare = goldShare;
    }
    public int getNeutralObjectiveStolen() {
        return neutralObjectiveStolen;
    }
    public void setNeutralObjectiveStolen(int neutralObjectiveStolen) {
        this.neutralObjectiveStolen = neutralObjectiveStolen;
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
