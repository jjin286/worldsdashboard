package jj.projects.worldsdashboard.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Champion {
    @Id
    private String id;
    private String champion;
    private String sumTotal;
    private String winTotal;
    private String loseTotal;
    private String winrateTotal;
    private String pickRate;
    private String sumBlueSide;
    private String winBlueSide;
    private String loseBlueSide;
    private String winrateBlueSide;
    private String sumRedSide;
    private String winRedSide;
    private String loseRedSide;
    private String winrateRedSide;
    private String sumBans;
    private String banRate;
    private String sumPickBan;
    private String pickBanRate;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(String sumTotal) {
        this.sumTotal = sumTotal;
    }

    public String getWinTotal() {
        return winTotal;
    }

    public void setWinTotal(String winTotal) {
        this.winTotal = winTotal;
    }

    public String getLoseTotal() {
        return loseTotal;
    }

    public void setLoseTotal(String loseTotal) {
        this.loseTotal = loseTotal;
    }

    public String getWinrateTotal() {
        return winrateTotal;
    }

    public void setWinrateTotal(String winrateTotal) {
        this.winrateTotal = winrateTotal;
    }

    public String getPickRate() {
        return pickRate;
    }

    public void setPickRate(String pickRate) {
        this.pickRate = pickRate;
    }

    public String getSumBlueSide() {
        return sumBlueSide;
    }

    public void setSumBlueSide(String sumBlueSide) {
        this.sumBlueSide = sumBlueSide;
    }

    public String getWinBlueSide() {
        return winBlueSide;
    }

    public void setWinBlueSide(String winBlueSide) {
        this.winBlueSide = winBlueSide;
    }

    public String getLoseBlueSide() {
        return loseBlueSide;
    }

    public void setLoseBlueSide(String loseBlueSide) {
        this.loseBlueSide = loseBlueSide;
    }

    public String getWinrateBlueSide() {
        return winrateBlueSide;
    }

    public void setWinrateBlueSide(String winrateBlueSide) {
        this.winrateBlueSide = winrateBlueSide;
    }

    public String getSumRedSide() {
        return sumRedSide;
    }

    public void setSumRedSide(String sumRedSide) {
        this.sumRedSide = sumRedSide;
    }

    public String getWinRedSide() {
        return winRedSide;
    }

    public void setWinRedSide(String winRedSide) {
        this.winRedSide = winRedSide;
    }

    public String getLoseRedSide() {
        return loseRedSide;
    }

    public void setLoseRedSide(String loseRedSide) {
        this.loseRedSide = loseRedSide;
    }

    public String getWinrateRedSide() {
        return winrateRedSide;
    }

    public void setWinrateRedSide(String winrateRedSide) {
        this.winrateRedSide = winrateRedSide;
    }

    public String getSumBans() {
        return sumBans;
    }

    public void setSumBans(String sumBans) {
        this.sumBans = sumBans;
    }

    public String getBanRate() {
        return banRate;
    }

    public void setBanRate(String banRate) {
        this.banRate = banRate;
    }

    public String getSumPickBan() {
        return sumPickBan;
    }

    public void setSumPickBan(String sumPickBan) {
        this.sumPickBan = sumPickBan;
    }

    public String getPickBanRate() {
        return pickBanRate;
    }

    public void setPickBanRate(String pickBanRate) {
        this.pickBanRate = pickBanRate;
    }
}
