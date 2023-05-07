package jj.projects.worldsdashboard.data;

import jj.projects.worldsdashboard.model.Champion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class ChampionProcessor implements ItemProcessor<ChampionInput, Champion> {

    private static final Logger log = LoggerFactory.getLogger(ChampionProcessor.class);

    @Override
    public Champion process(final ChampionInput championInput) throws Exception {
        Champion champion = new Champion();
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
        champion.setSumBans(Integer.parseInt(championInput.getSum_bans()));
        champion.setBanRate(championInput.getBan_rate());
        champion.setSumPickBan(Integer.parseInt(championInput.getSum_pick_ban()));
        champion.setPickBanRate(championInput.getPick_ban_rate());
        log.info("Converting (" + championInput + ") into (" + champion + ")");
        return champion;
    }

}