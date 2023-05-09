package jj.projects.worldsdashboard.data._2020.Champion;

import jj.projects.worldsdashboard.model._2020.Champion2020;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ChampionProcessor2020 implements ItemProcessor<ChampionInput2020, Champion2020> {

    // private static final Logger log = LoggerFactory.getLogger(ChampionProcessor2020.class);

    @Override
    public Champion2020 process(final ChampionInput2020 championInput) throws Exception {
        Champion2020 champion = new Champion2020();
        champion.setId(Integer.parseInt(championInput.getId()));
        champion.setChampion(championInput.getChampion());
        champion.setSumTotal(Integer.parseInt(championInput.getSum_total()));
        champion.setWinTotal(Integer.parseInt(championInput.getWin_total()));
        champion.setLoseTotal(Integer.parseInt(championInput.getLose_total()));
        champion.setWinrateTotal(championInput.getWinrate_total());
        champion.setPickRate(championInput.getPick_rate());
        champion.setSumBlueSide(Integer.parseInt(championInput.getSum_blue_side()));
        champion.setWinBlueSide(Integer.parseInt(championInput.getWin_blue_side()));
        champion.setLoseBlueSide(Integer.parseInt(championInput.getLose_blue_side()));
        champion.setWinrateBlueSide(championInput.getWinrate_blue_side());
        champion.setSumRedSide(Integer.parseInt(championInput.getSum_red_side()));
        champion.setWinRedSide(Integer.parseInt(championInput.getWin_red_side()));
        champion.setLoseRedSide(Integer.parseInt(championInput.getLose_red_side()));
        champion.setWinrateRedSide(championInput.getWinrate_red_side());
        // champion.setSumBans(Integer.parseInt(championInput.getSum_bans()));
        // champion.setBanRate(championInput.getBan_rate());
        // champion.setSumPickBan(Integer.parseInt(championInput.getSum_pick_ban()));
        // champion.setPickBanRate(championInput.getPick_ban_rate());
        // log.info("Converting (" + championInput + ") into (" + champion + ")");
        return champion;
    }

}