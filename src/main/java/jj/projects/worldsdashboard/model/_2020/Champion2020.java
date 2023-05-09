package jj.projects.worldsdashboard.model._2020;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Champion2020 {
    @Id
    private int id;
    private String champion;
    private int sumTotal;
    private int winTotal;
    private int loseTotal;
    private String pickRate;
    private String winrateTotal;
    private int sumBlueSide;
    private int winBlueSide;
    private int loseBlueSide;
    private String winrateBlueSide;
    private int sumRedSide;
    private int winRedSide;
    private int loseRedSide;
    private String winrateRedSide;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public int getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(int sumTotal) {
        this.sumTotal = sumTotal;
    }

    public int getWinTotal() {
        return winTotal;
    }

    public void setWinTotal(int winTotal) {
        this.winTotal = winTotal;
    }

    public int getLoseTotal() {
        return loseTotal;
    }

    public void setLoseTotal(int loseTotal) {
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

    public int getSumBlueSide() {
        return sumBlueSide;
    }

    public void setSumBlueSide(int sumBlueSide) {
        this.sumBlueSide = sumBlueSide;
    }

    public int getWinBlueSide() {
        return winBlueSide;
    }

    public void setWinBlueSide(int winBlueSide) {
        this.winBlueSide = winBlueSide;
    }

    public int getLoseBlueSide() {
        return loseBlueSide;
    }

    public void setLoseBlueSide(int loseBlueSide) {
        this.loseBlueSide = loseBlueSide;
    }

    public String getWinrateBlueSide() {
        return winrateBlueSide;
    }

    public void setWinrateBlueSide(String winrateBlueSide) {
        this.winrateBlueSide = winrateBlueSide;
    }

    public int getSumRedSide() {
        return sumRedSide;
    }

    public void setSumRedSide(int sumRedSide) {
        this.sumRedSide = sumRedSide;
    }

    public int getWinRedSide() {
        return winRedSide;
    }

    public void setWinRedSide(int winRedSide) {
        this.winRedSide = winRedSide;
    }

    public int getLoseRedSide() {
        return loseRedSide;
    }

    public void setLoseRedSide(int loseRedSide) {
        this.loseRedSide = loseRedSide;
    }

    public String getWinrateRedSide() {
        return winrateRedSide;
    }

    public void setWinrateRedSide(String winrateRedSide) {
        this.winrateRedSide = winrateRedSide;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id=" + id +
                ", champion='" + champion + '\'' +
                ", sumTotal=" + sumTotal +
                ", winTotal=" + winTotal +
                ", loseTotal=" + loseTotal +
                ", winrateTotal='" + winrateTotal + '\'' +
                ", pickRate='" + pickRate + '\'' +
                ", sumBlueSide=" + sumBlueSide +
                ", winBlueSide=" + winBlueSide +
                ", loseBlueSide=" + loseBlueSide +
                ", winrateBlueSide='" + winrateBlueSide + '\'' +
                ", sumRedSide=" + sumRedSide +
                ", winRedSide=" + winRedSide +
                ", loseRedSide=" + loseRedSide +
                ", winrateRedSide='" + winrateRedSide + '\'' +
                '}';
    }

    public Champion2020(){

    }
}
